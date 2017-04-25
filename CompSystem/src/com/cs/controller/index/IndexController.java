package com.cs.controller.index;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cs.pojo.Competition;
import com.cs.pojo.FileUpload;
import com.cs.service.article.ArticleService;
import com.cs.service.competition.CompetitionService;
import com.cs.service.fileUpload.FileUploadService;
import com.cs.service.production.ProductionService;
import com.cs.util.PageInfo;
import com.cs.util.ParamUtil;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	@Autowired
	ArticleService articlService;
	
	@Autowired
	ProductionService productionService;
	
	@Autowired
	CompetitionService compeService;
	@Autowired
	FileUploadService fileService;
	
	
	/**
	 * 分页根据文章类型找到相关文章
	 * @param type 文章类型
	 * @param page 页数
	 * @param pageSize 每页数量 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/articlesList", method = RequestMethod.GET)
	public  Map findArticleByType(String type,String index,String pageSize) {
		Map<String,Object> result=new HashMap<String, Object>();
		Map<String,Object> param=new HashMap<String, Object>();
		type=ParamUtil.getStr(type, "1");
		index=ParamUtil.getStr(index, "1");
		pageSize=ParamUtil.getStr(pageSize, "10");
		param.put("type", type);
		param.put("index", index);
		param.put("pageSize",pageSize);
		System.out.println(param+"---");
		PageInfo pageInfo=articlService.getArticleList(param);
		result.put("articlePageInfo",pageInfo );
		return result;
	}
	
	/**
	 * 
	 * @param searchInput
	 * @param type
	 * @param index
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/searchArticle", method = RequestMethod.GET)
	public  Map searchArticle(String searchInput,String type,String index,String pageSize) {
		Map<String,Object> result=new HashMap<String, Object>();
		Map<String,Object> param=new HashMap<String, Object>();

		type=ParamUtil.getStr(type, "");
		index=ParamUtil.getStr(index, "1");
		pageSize=ParamUtil.getStr(pageSize, "10");
		param.put("type", type);
		param.put("index", index);
		param.put("pageSize",pageSize);
		param.put("searchInput",searchInput);
		
		PageInfo pageInfo=articlService.searchArticle(param);
		result.put("articlePageInfo",pageInfo );
		return result;
	}
	
	/**
	 * 获取当个文章
	 * @param type 文章类型
	 * @param page 页数
	 * @param pageSize 每页数量 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/article", method = RequestMethod.GET)
	public  Map findArticleById(String articleId) {
		Map<String,Object> result=new HashMap<String, Object>();
		if(articleId!=null && !"".equals(articleId)){
			int id=Integer.parseInt(articleId);
			result=articlService.getArticleByID(id);
		}
		
		return result;
	}
	
	
	/**
	 * 获取近期的优秀作品（可以报名）
	 * @param type
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/productionList")
	public  Map productionList(String index,String pageSize) {
		Map<String ,Object> resultMap=new HashMap<String, Object>();
		Map<String ,Object> param=new HashMap<String, Object>();
		index=ParamUtil.getStr(index, "1");
		pageSize=ParamUtil.getStr(pageSize, "6");
		
		param.put("index", index);	
		param.put("pageSize", pageSize);	
		PageInfo pageInfo=new PageInfo();
		pageInfo=productionService.productioList(param);
		resultMap.put("produPageInfo", pageInfo);
		System.out.println(param+"\n"+resultMap);
		
		return resultMap;
	}
	
	/**
	 * 获取近期的竞赛（可以报名）
	 * @param type
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/CompetionList")
	public  Map CompetitionList(String department,String time,String index,String pageSize) {
		Map<String ,Object> resultMap=new HashMap<String, Object>();
		
		List<Competition> todayList=new ArrayList<Competition>();
		List<Competition> yestedayList=new ArrayList<Competition>();
		List<Competition> tomorrowList=new ArrayList<Competition>();
		List<Competition> lastWeekList=new ArrayList<Competition>();
		List<Competition> nextWeekList=new ArrayList<Competition>();
		List<Competition> lastMoonList=new ArrayList<Competition>();
		
		todayList=compeService.todayCompetition();
		yestedayList=compeService.yesterdayCompetition();
		tomorrowList=compeService.tomorrowCompetition();
		lastWeekList=compeService.lastWeekCompetition();
		nextWeekList=compeService.nextWeekCompetition();
		lastMoonList=compeService.lastMoonCompetition();
		
		resultMap.put("today", todayList);
		resultMap.put("yesterday", yestedayList);
		resultMap.put("tomorrow", tomorrowList);
		resultMap.put("lastWeek", lastWeekList);
		resultMap.put("nextWeek", nextWeekList);
		resultMap.put("lastMoon", lastMoonList);
		
		return resultMap;
	}
	
	/*@ResponseBody
	@RequestMapping("/CompetionList")
	public  Map CompetitionList(String department,String time,String index,String pageSize) {
		Map<String ,Object> resultMap=new HashMap<String, Object>();
		Map<String ,Object> param=new HashMap<String, Object>();
		department=ParamUtil.getStr(department, "");
		time=ParamUtil.getStr(time, "");
		index=ParamUtil.getStr(index, "1");
		pageSize=ParamUtil.getStr(pageSize, "10");
		
		param.put("department", department);
		param.put("time", time);	
		param.put("index", index);	
		
		param.put("pageSize", pageSize);	
		
		PageInfo pageInfo=new PageInfo();
		
		pageInfo=compeService.CompetitionList(param);
		
		resultMap.put("comPageInfo", pageInfo);
		System.out.println(param+"\n"+resultMap);
		
		return resultMap;
	}*/
	
	/**
	 * 文件下载
	 * @param department
	 * @param time
	 * @param index
	 * @param pageSize
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@ResponseBody
	@RequestMapping("/fileDownload")
	public  void fileDownload(String fileId,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		FileUpload fileupload=fileService.findFileById(Integer.parseInt(fileId));
		System.out.println(fileupload);
		String fileName=fileupload.getFilename();
		String saveName=fileupload.getSavename();
		System.out.println(fileName);
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/uploadFile");
		path+="/"+saveName;
		File file = new File(path);
		String name= new String(fileName.getBytes("GBK"), "ISO-8859-1");
        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition",
                    "attachment;fileName="+name);// 设置文件名
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
		
	}
	
	/**
	 * 文件列表
	 * @param index
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/allFile")
	public Map allFile(String index,String pageSize){
		Map result=new HashMap<String,Object>();
		Map param=new HashMap<String,Object>();
		PageInfo pageinfo=new PageInfo();
		index=ParamUtil.getStr(index, "1");
		pageSize=ParamUtil.getStr(pageSize, "10");
		param.put("index",index);
		param.put("pageSize",pageSize);
		pageinfo=fileService.allFile(param);
		result.put("filePage", pageinfo);
		return result;
	}
	
	
	
}
