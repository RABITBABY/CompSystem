package com.cs.service.teacher;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.sun.org.apache.regexp.internal.recompile;

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
		int updateByPrimaryKey = teacherMapper
				.updateByPrimaryKeySelective(teacher);
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
	public File createWord(Integer comId) {
		Configuration configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");
		File outFile = null;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Competition competition = comMapper.selectByPrimaryKey(comId);
			List<Teacher> guideTeachers = guideTeacherMapper.selectComId(comId);
			Teacher teacher=teacherMapper.selectByPrimaryKey(competition.getLeaderNo());
		    dataMap.put("comName", competition.getComname());
			dataMap.put("unit", competition.getUnit());
			dataMap.put("rank", competition.getLevelname());
			if (competition.getDate()!=null) {
				Date date = competition.getDate();
				String format = sdf.format(date);
				dataMap.put("date",format);
			}else {
				dataMap.put("date", "");
			}
			dataMap.put("host", competition.getHost());
			if(competition.getTime()!=null){
				 Date time = competition.getTime();
				 String format = sdf.format(time);
				dataMap.put("time",format);
			}else {
				dataMap.put("time","");
			}
			dataMap.put("place", competition.getPlace());
			dataMap.put("object", competition.getObject());
			dataMap.put("people", competition.getPeople());
			dataMap.put("sponsor", competition.getSponsor());
			dataMap.put("introduce", competition.getIntroduce());
			dataMap.put("phone", teacher.getPhone());
			dataMap.put("email", teacher.getEmail());
			dataMap.put("leader", teacher.getTeachername());
            dataMap.put("guideList",guideTeachers);
		    

			// FTL文件所存在的位置
			configuration.setClassForTemplateLoading(this.getClass(), "/file");
			Template template = configuration.getTemplate("approveTable.ftl");

			outFile = new File(competition.getComname() + "申报书.doc");
			Writer out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(outFile), "UTF-8"));
			template.process(dataMap, out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outFile;
	}

	@Override
	@Transactional
	public CompetitionInfoVo addComp(CompetitionInfoVo compVo) {
		Competition competition = compVo.getCompetition();
		competition.setCompstatus(0);
		competition.setDepspstatus(0);
		competition.setIspublish(0);
		competition.setTeaspstatus(0);
		comMapper.insertSelective(competition);
		// 得到竞赛id
		int comId = competition.getComid();
		// 经费预算
		List<Budget> bList = compVo.getBudgets();
		if (bList != null && bList.size() > 0) {
			for (int i = 0; i < bList.size(); i++) {
				bList.get(i).setComid(comId);
			}
			budgetMapper.addCompBudgetBatch(bList);
		}
		// 竞赛条件
		List<CompCondition> compConditionsList = compVo.getCompConditions();
		if (compConditionsList != null && compConditionsList.size() > 0) {
			for (int i = 0; i < compConditionsList.size(); i++) {
				compConditionsList.get(i).setComid(comId);
			}
			compConditionMapper.addCompConditionBatch(compConditionsList);
		}
		// 指导老师
		List<GuideTeacher> guideList = compVo.getGuideTeachers();
		if (guideList != null && guideList.size() > 0) {
			for (int i = 0; i < guideList.size(); i++) {
				guideList.get(i).setComid(comId);
			}
			guideTeacherMapper.addCompGuideTeacherBatch(guideList);
		}
		// 课时预算
		List<Hours> hoursList = compVo.getHours();
		if (hoursList != null && hoursList.size() > 0) {
			for (int i = 0; i < hoursList.size(); i++) {
				hoursList.get(i).setComid(comId);
			}
			hoursMapper.addCompHoursBatch(hoursList);
		}
		// 培训安排
		List<Schedule> scheduleList = compVo.getSchedules();
		if (scheduleList != null && scheduleList.size() > 0) {
			for (int i = 0; i < scheduleList.size(); i++) {
				scheduleList.get(i).setComid(comId);
			}
			scheduleMapper.addCompScheduleBatch(scheduleList);
		}

		return compVo;
	}

	@Override
	@Transactional
	public CompetitionInfoVo updateComp(CompetitionInfoVo compVo) {
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
		Integer comId=competition.getComid();
		// 经费预算
		// 先删除久的。再插入新的。
		// 经费预算
		budgetMapper.deleteByComId(comId);
		List<Budget> bList = compVo.getBudgets();
		if (bList != null && bList.size() > 0) {
			for (int i = 0; i < bList.size(); i++) {
				bList.get(i).setComid(comId);
			}
			budgetMapper.addCompBudgetBatch(bList);
		}
		// 竞赛条件
		compConditionMapper.deleteByComId(comId);
		List<CompCondition> compConditionsList = compVo.getCompConditions();
		if (compConditionsList != null && compConditionsList.size() > 0) {
			for (int i = 0; i < compConditionsList.size(); i++) {
				compConditionsList.get(i).setComid(comId);
			}
			compConditionMapper.addCompConditionBatch(compConditionsList);
		}
		// 指导老师
		guideTeacherMapper.deleteByComId(comId);
		List<GuideTeacher> guideList = compVo.getGuideTeachers();
		if (guideList != null && guideList.size() > 0) {
			for (int i = 0; i < guideList.size(); i++) {
				guideList.get(i).setComid(comId);
			}
			guideTeacherMapper.addCompGuideTeacherBatch(guideList);
		}
		// 课时预算
		hoursMapper.deleteByComId(comId);
		List<Hours> hoursList = compVo.getHours();
		if (hoursList != null && hoursList.size() > 0) {
			for (int i = 0; i < hoursList.size(); i++) {
				hoursList.get(i).setComid(comId);
			}
			hoursMapper.addCompHoursBatch(hoursList);
		}
		// 培训安排
		scheduleMapper.deleteByComId(comId);
		List<Schedule> scheduleList = compVo.getSchedules();
		if (scheduleList != null && scheduleList.size() > 0) {
			for (int i = 0; i < scheduleList.size(); i++) {
				scheduleList.get(i).setComid(comId);
			}
			scheduleMapper.addCompScheduleBatch(scheduleList);
		}
		return compVo;
	}

	/**
	 * 每5秒保存一次。
	 */
	@Override
	@Transactional
	public CompetitionInfoVo addOrUpdateComp(CompetitionInfoVo compVo) {
		Competition competition = compVo.getCompetition();
		if (competition.getComid() != null) {
			CompetitionInfoVo updateComp = updateComp(compVo);

			return updateComp;
		} else {
			CompetitionInfoVo addComp = addComp(compVo);

			return addComp;
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
		List<Competition> list = new ArrayList<Competition>();
		Teacher teacher = teacherMapper.selectByPrimaryKey(teacherno);
		if (teacher.getDepartment().equals("教学处") && teacher.getExaminer() == 1) {
			list = comMapper.examTeaComp(teacherno);
		} else if ((!teacher.getDepartment().equals("教学处"))
				&& teacher.getExaminer() == 1) {
			list = comMapper.examDeptComp(teacherno);
		}

		return list;
	}

	@Override
	public List<Competition> selectAllComp() {
		return comMapper.selectAllComp();
	}

	@Override
	public List<Competition> selectByLeaderNo(Integer leaderNo) {
		return comMapper.selectByLeaderNo(leaderNo);
	}

	@Override
	public List<Competition> selectScheCompByTeacherNo(Integer teacherno) {
		return comMapper.selectScheCompByTeacherNo(teacherno);
	}

	@Override
	public List<Competition> selectGuideCompByTeacherNo(Integer teacherno) {
		return comMapper.selectGuideCompByTeacherNo(teacherno);
	}

}
