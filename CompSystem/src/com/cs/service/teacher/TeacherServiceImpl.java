package com.cs.service.teacher;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs.dao.awards.AwardsMapper;
import com.cs.dao.budget.BudgetMapper;
import com.cs.dao.compcondition.CompConditionMapper;
import com.cs.dao.competition.CompetitionMapper;
import com.cs.dao.group.GroupsMapper;
import com.cs.dao.guideteacher.GuideTeacherMapper;
import com.cs.dao.hour.HoursMapper;
import com.cs.dao.schedule.ScheduleMapper;
import com.cs.dao.teacher.TeacherMapper;
import com.cs.pojo.Awards;
import com.cs.pojo.Budget;
import com.cs.pojo.CompCondition;
import com.cs.pojo.Competition;
import com.cs.pojo.Conditions;
import com.cs.pojo.Groups;
import com.cs.pojo.GuideTeacher;
import com.cs.pojo.Hours;
import com.cs.pojo.Schedule;
import com.cs.pojo.Student;
import com.cs.pojo.Teacher;
import com.cs.vo.CompetitionInfoVo;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private CompetitionMapper comMapper;
	@Autowired
	private GroupsMapper groupsMapper;
	@Autowired
	private BudgetMapper budgetMapper;
	@Autowired
	private ScheduleMapper scheduleMapper;
	@Autowired
	private HoursMapper hoursMapper;
	@Autowired
	private GuideTeacherMapper guideTeacherMapper;
	@Autowired
	private CompConditionMapper compConditionMapper;
	@Autowired
	private AwardsMapper awardsMapper;

	@Override
	public Teacher selectByTeacherNo(Integer teacherNo) {
		return teacherMapper.selectByPrimaryKey(teacherNo);
	}

	@Override
	@Transactional
	public void deleteComp(Integer comId) {
		comMapper.deleteByPrimaryKey(comId);
		// 经费预算
		budgetMapper.deleteByComId(comId);
		// 竞赛条件
		compConditionMapper.deleteByComId(comId);
		// 指导老师
		guideTeacherMapper.deleteByComId(comId);
		// 课时预算
		hoursMapper.deleteByComId(comId);
		// 培训安排
		scheduleMapper.deleteByComId(comId);
	}

	@Override
	public List<Competition> getCompResults(Integer teacherNo) {
		return comMapper.selectByTeacherno(teacherNo);
	}

	
	@Override
	public boolean updateByTeacherNo(Teacher teacher) {
		int updateByPrimaryKey = teacherMapper.updateByPrimaryKeySelective(teacher);
		if (updateByPrimaryKey > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Competition> getCompBySpStatus(Competition competition) {

		return comMapper.selectBySpStatus(competition);
	}

	@Override
	public Map<String, Object> getCompDetail(Integer comId) {
		// 根据comId查找基本信息
		Competition competition = comMapper.selectByPrimaryKey(comId);
		List<Budget> budgets = budgetMapper.selectByComId(comId);
		List<Schedule> schedules = scheduleMapper.selectByComId(comId);
		List<Hours> hours = hoursMapper.selectByComId(comId);
		List<Teacher> teachers = guideTeacherMapper.selectComId(comId);
		List<Conditions> conditions = compConditionMapper.selectComId(comId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("competition", competition);
		map.put("budgets", budgets);
		map.put("schedules", schedules);
		map.put("hours", hours);
		map.put("teachers", teachers);
		map.put("conditions", conditions);
		return map;
	}

	@Override
	public List<Student> getGroupsMember(Integer groupsNo) {

		return groupsMapper.selectByGroupsNo(groupsNo);
	}

	@Override
	public boolean approveGroups(Groups groups) {
		int updateStatus = groupsMapper.updateStatus(groups);
		if (updateStatus > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Competition> getEndCompetition(Integer teacherNo) {

		return comMapper.selectEndComp(teacherNo);
	}

	@Override
	public boolean setCompResult(Awards awards) {
		int insertSelective = awardsMapper.insertSelective(awards);
		if (insertSelective > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean createWord(Integer comId) {
		Configuration configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		try {
			Competition competition = comMapper.selectByPrimaryKey(comId);
			dataMap.put("comName", competition.getComname());

			configuration.setClassForTemplateLoading(this.getClass(), "/file"); // FTL文件所存在的位置
			Template template = configuration.getTemplate("approveTable.ftl");

			File outFile = new File("E:/temp/" + competition.getComname()
					+ "申报书.doc");
			Writer out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(outFile), "UTF-8"));
			template.process(dataMap, out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	@Transactional
	public void addComp(CompetitionInfoVo compVo) {
		Competition competition = compVo.getCompetition();
		competition.setCompstatus(0);
		competition.setDepspstatus(0);
		competition.setIspublish(0);
		competition.setTeaspstatus(0);
		comMapper.insertSelective(competition);
		// 得到竞赛id
		int comId = compVo.getCompetition().getComid();
		// 经费预算
		List<Budget> bList = compVo.getBudgets();
		if (bList != null&&bList.size()>0) {
			for (int i = 0; i < bList.size(); i++) {
				bList.get(i).setComid(comId);
			}
			budgetMapper.addCompBudgetBatch(bList);
		}
		// 竞赛条件
		List<CompCondition> compConditionsList = compVo.getCompConditions();
		if (compConditionsList != null&&compConditionsList.size()>0) {
			for (int i = 0; i < compConditionsList.size(); i++) {
				compConditionsList.get(i).setComid(comId);
			}
			compConditionMapper.addCompConditionBatch(compConditionsList);
		}
		// 指导老师
		List<GuideTeacher> guideList = compVo.getGuideTeachers();
		if (guideList != null&&guideList.size()>0) {
			for (int i = 0; i < guideList.size(); i++) {
				guideList.get(i).setComid(comId);
			}
			guideTeacherMapper.addCompGuideTeacherBatch(guideList);
		}
		// 课时预算
		List<Hours> hoursList = compVo.getHours();
		if (hoursList != null&&hoursList.size()>0) {
			for (int i = 0; i < hoursList.size(); i++) {
				hoursList.get(i).setComid(comId);
			}
			hoursMapper.addCompHoursBatch(hoursList);
		}
		// 培训安排
		List<Schedule> scheduleList = compVo.getSchedules();
		if (scheduleList != null&&scheduleList.size()>0) {
			for (int i = 0; i < scheduleList.size(); i++) {
				scheduleList.get(i).setComid(comId);
			}
			scheduleMapper.addCompScheduleBatch(scheduleList);
		}
	}

	@Override
	@Transactional
	public void updateComp(CompetitionInfoVo compVo) {
		Competition competition = compVo.getCompetition();
		competition.setCompstatus(0);
		competition.setDepspstatus(0);
		competition.setIspublish(0);
		competition.setTeaspstatus(0);
		competition.setUopinion("");
		competition.setDsign("");
		competition.setTdopinion("");
		competition.setOlsign("");
		comMapper.updateByPrimaryKeySelective(competition);
		// 经费预算
		List<Budget> bList = compVo.getBudgets();
		if (bList != null&&bList.size()>0) {
			for (int i = 0; i < bList.size(); i++) {
				budgetMapper.updateByPrimaryKeySelective(bList.get(i));
			}
		}
		// 竞赛条件
		List<CompCondition> compConditionsList = compVo.getCompConditions();
		if (compConditionsList != null&&compConditionsList.size()>0) {
			for (int i = 0; i < compConditionsList.size(); i++) {
				compConditionMapper
						.updateByPrimaryKeySelective(compConditionsList.get(i));
			}
		}
		// 指导老师
		List<GuideTeacher> guideList = compVo.getGuideTeachers();
		if (guideList != null&&guideList.size()>0) {
			for (int i = 0; i < guideList.size(); i++) {
				guideTeacherMapper
						.updateByPrimaryKeySelective(guideList.get(i));
			}
		}
		// 课时预算
		List<Hours> hoursList = compVo.getHours();
		if (hoursList != null&&hoursList.size()>0) {
			for (int i = 0; i < hoursList.size(); i++) {
				hoursMapper.updateByPrimaryKeySelective(hoursList.get(i));
			}
		}
		// 培训安排
		List<Schedule> scheduleList = compVo.getSchedules();
		if (scheduleList != null&&scheduleList.size()>0) {
			for (int i = 0; i < scheduleList.size(); i++) {
				scheduleMapper.updateByPrimaryKeySelective(scheduleList.get(i));
			}
		}
	}

	@Override
	public void updateCompStatusByDept(Competition competition) {
		// TODO Auto-generated method stub
		comMapper.updateByDeptAdmin(competition);
	}

	@Override
	public void updateCompStatusByTea(Competition competition) {
		// TODO Auto-generated method stub
		comMapper.updateByTea(competition);
	}

	@Override
	public List<Teacher> selectAllTeacher() {
		return teacherMapper.selectAllTeacher();
	}

	@Override
	public List<Competition> getApproCompList(Integer teacherno) {
		List<Competition> list=new ArrayList<Competition>();
		Teacher teacher = teacherMapper.selectByPrimaryKey(teacherno);
		if (teacher.getDepartment().equals("教学处") && teacher.getExaminer()==1) {
			list=comMapper.examTeaComp(teacherno);
		}else if((!teacher.getDepartment().equals("教学处")) && teacher.getExaminer()==1){
			list=comMapper.examDeptComp(teacherno);
		}

		return list;
	}

}
