package com.cs.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.cs.pojo.Article;
import com.cs.pojo.Competition;
import com.cs.pojo.FileUpload;
import com.cs.pojo.Production;
import com.cs.service.administer.AdministerServiceImpl;
import com.cs.service.article.ArticleService;
import com.cs.service.article.ArticleServiceImpl;
import com.cs.service.award.AwardsService;
import com.cs.service.fileUpload.FileUploadService;
import com.cs.service.production.ProductionService;
import com.cs.util.PageInfo;
import com.cs.util.ParamUtil;



@Controller
@RequestMapping("/admin")
public class AdministerController {

	@Autowired
	AdministerServiceImpl adminImpl;
	
	@Autowired
	ProductionService productionService;
	
	@Autowired
	AwardsService awardsService;
	
	@Autowired
	FileUploadService fileUploadService;
	
	@Autowired
	ArticleService articleService;
	
	
	/**
	 * 获取近期的竞赛（可以报名）
	 * @param type
	 * @return
	 */
	@ResponseBody
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
		
		pageInfo=adminImpl.CompetitionList(param);
		
		resultMap.put("comPageInfo", pageInfo);
		System.out.println(param+"\n"+resultMap);
		
		return resultMap;
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
		pageSize=ParamUtil.getStr(pageSize, "3");
		
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
	@RequestMapping("/awardList")
	public  Map awardsList(String department,String time,String index,String pageSize) {
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
		
		pageInfo=awardsService.getAwardsList(param);
		
		resultMap.put("awardsList", pageInfo);
		System.out.println(param+"\n"+resultMap);
		
		return resultMap;
	}

	//---------文章相关
	
	/**
	 * 分页根据文章类型找到相关文章
	 * @param type 文章类型
	 * @param page 页数
	 * @param pageSize 每页数量 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/article", method = RequestMethod.GET)
	public  Map findArticleByType(String type,String index,String pageSize) {
		Map<String,Object> result=new HashMap<String, Object>();
		Map<String,Object> param=new HashMap<String, Object>();
		type=ParamUtil.getStr(type, "1");
		index=ParamUtil.getStr(index, "1");
		pageSize=ParamUtil.getStr(pageSize, "10");
		param.put("type", type);
		param.put("index", index);
		param.put("pageSize",pageSize);
		
		PageInfo pageInfo=articleService.getArticleList(param);
		result.put("articlePageInfo",pageInfo );
		return result;
	}
	
	
	@ResponseBody
	@RequestMapping("/pubArticle")
	public String pubArticle(String title,String content,String articleType,String relationId,HttpServletRequest request) {
		String stateCode="0";
		 title=ParamUtil.getStr(title, "");
		 content=ParamUtil.getStr(content, "");
		 articleType=ParamUtil.getStr(articleType, "1");
		 relationId=ParamUtil.getStr(relationId, "0");
		 Map userInfo=(Map)request.getSession().getAttribute("loginInfo");
		 String userNo="";
		 if(userInfo!=null){
			userNo=userInfo.get("userId").toString();
			if(userNo!=null && !"".equals(userNo)){
				Article article=new Article();
				article.setTitle(title);
				article.setContent(content);
				article.setRelationId(Integer.parseInt(relationId));
				article.setArticletype(Integer.parseInt(articleType));
				article.setPubdate(new Date());
				article.setPubuserno(userNo);
				int state=articleService.insertArticle(article);
				if(state>0){
					stateCode="1";
				}
				System.out.println(article);
			}
		}
		//获取当前登录用户
		return stateCode;
	}
	
	/**
	 * 修改文章
	 * @param articleId
	 * @param relationId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateArticle")
	public int updateArticle(String title,String content,int articleId) {
		int stateCode=0;
		title=ParamUtil.getStr(title, "");
		content=ParamUtil.getStr(content, "");
		stateCode=articleService.updateArticle(articleId, title, content);
		return stateCode;
	}
	
	/**
	 * 获取单篇文章
	 * @param articleId
	 * @param relationId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findArticle")
	public Map findArticle(int articleId) {
		String stateCode="0";
		Map map=articleService.getArticleByID(articleId);
		if(map!=null&&map.size()>0){
			stateCode="1";
		}
		return map;
	}
	
	/**
	 * 删除文章
	 * @param articleId
	 * @param relationId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteArticle")
	public int deleteArticle(int articleId) {
		int stateCode=0;
		
		 Map article= articleService.getArticleByID(articleId);
		 int type=Integer.parseInt(article.get("articleType").toString());
		 int relationId=Integer.parseInt(article.get("relationId").toString());
		//获取当前登录用户
		 stateCode= articleService.deleteArticle(articleId, relationId, type);
		return stateCode;
	}
	
	
	/*//---------作品相关
	*//**
	 * 上传优秀作品
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 *//*
	@RequestMapping("/uploadProduction")
	public String uploadProduction(String proName,String award,String membersName,String introduction, HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
		//上传图片 //进行转换  
        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)(request);  
        //获取所有文件名称  
        Iterator<String> it = multiRequest.getFileNames();  
        while(it.hasNext()){  
            //根据文件名称取文件  
            MultipartFile file = multiRequest.getFile(it.next());  
            String fileName = file.getOriginalFilename();  //文件名
            String uploadName = String.valueOf( System.currentTimeMillis());//时间戳字符串
            String fileType=fileName.substring(fileName.indexOf("."), fileName.length());
            if(".JPG".equals(fileType.toUpperCase()) ||".PNG".equals(fileType.toUpperCase())||".JPEG".equals(fileType.toUpperCase())){
            	uploadName=uploadName+fileType;
                
                String path = request.getSession().getServletContext().getRealPath("/WEB-INF/productionImg");  
                path=path+"/"+uploadName;
                File newFile = new File(path);  
                //上传的文件写入到指定的文件中  
                file.transferTo(newFile);
                System.out.println("uploadName:"+uploadName);
            }else{
            	System.out.println("不是图片");
            }
            
             
        }
		
		//保存数据库
		
		proName=request.getAttribute("proName").toString();
		award=request.getAttribute("award").toString();
		membersName=request.getAttribute("membersName").toString();
		introduction=request.getAttribute("introduction").toString();
		Production production=new Production();
		production.setProname(proName);
		production.setAward(award);
		production.setMembersname(membersName);
		production.setIntroduction(introduction);
		System.out.println("production:"+production);
		
		return "1";
	}
	
	*/
	
	
	//---------文件相关

	/**
	 * 文件上传
	 * @param request
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/uploadFile")
	public String saveFile(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
		String statueCode="0"; 
		//获取解析器  
        CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
        //判断是否是文件  
        if(resolver.isMultipart(request)){  
            //进行转换  
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)(request);  
            //获取所有文件名称  
            Iterator<String> it = multiRequest.getFileNames();  
            while(it.hasNext()){  
                //根据文件名称取文件  
                MultipartFile file = multiRequest.getFile(it.next());  
                String fileName = file.getOriginalFilename();  //文件名
                String uploadName = String.valueOf( System.currentTimeMillis());//时间戳字符串
                String fileType=fileName.substring(fileName.indexOf("."), fileName.length());
                uploadName=uploadName+fileType;
                
                String path = request.getSession().getServletContext().getRealPath("/WEB-INF/uploadFile");  
                path=path+"/"+uploadName;
                File newFile = new File(path);  
                //上传的文件写入到指定的文件中  
                file.transferTo(newFile);  
                //获取当前用户的ID
               Map userInfo=(Map)request.getSession().getAttribute("loginInfo");
               String adminNo=(String) userInfo.get("userId");
                //保存进数据库
                FileUpload fileUpload=new FileUpload();
                fileUpload.setUploaddate(new Date());
                fileUpload.setSavename(uploadName);
                fileUpload.setFilename(fileName);
                fileUpload.setUploaduserno(adminNo);
                System.out.println(fileUpload);
               int insertStatue= fileUploadService.insertFile(fileUpload);
               if(insertStatue>0){
            	   statueCode="1";
               }
            }  
		}
        return statueCode;
	}
	
	
	
	/**
	 *删除文件
	 * @param request
	 * @param response
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/deleteFile")
	public String deleteFile(String fileId,HttpServletRequest request) {
		String statueCode="0"; 
		//找到文件名  删除本地文件
		int fileID=Integer.parseInt(fileId);
		FileUpload file=adminImpl.getFile(fileID);
		String fileName=file.getSavename();
		System.out.println("fileName---"+fileName);
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/uploadFile");  
		path+="/"+fileName;
		System.out.println("path:"+path);
		File deleteFile=new File(path);
		if(deleteFile.exists()){
			System.out.println("文件存在");
		}
		//删除数据库
		
        return statueCode;
	}
	
	
	
	
	
	
	
}
