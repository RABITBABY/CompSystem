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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.cs.pojo.Article;
import com.cs.pojo.Awards;
import com.cs.pojo.FileUpload;
import com.cs.pojo.Model;
import com.cs.pojo.Production;
import com.cs.service.administer.AdministerServiceImpl;
import com.cs.service.article.ArticleService;
import com.cs.service.award.AwardsService;
import com.cs.service.competition.CompetitionService;
import com.cs.service.fileUpload.FileUploadService;
import com.cs.service.model.ModelService;
import com.cs.service.production.ProductionService;
import com.cs.util.PageInfo;
import com.cs.util.ParamUtil;



@Controller
@RequestMapping("/admin")
public class AdministerController {

	@Autowired
	private AdministerServiceImpl adminImpl;
	
	@Autowired
	private ProductionService productionService;
	
	@Autowired
	private AwardsService awardsService;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private CompetitionService compeService;
	
	@Autowired
	private ModelService modelService;
	

	
	
	
	/**
	 * 获取近期的竞赛（可以报名）---只能查看到自己系的
	 * @param time
	 * 上周，，本周，， 本月
	 * levelName    竞赛类别
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/CompetionList")
	public  Map CompetitionList(String levelName,String time,String index,String pageSize,HttpServletRequest request) {
		Map<String ,Object> resultMap=new HashMap<String, Object>();
		Map<String ,Object> param=new HashMap<String, Object>();
		PageInfo pageInfo=new PageInfo();
		
		levelName=ParamUtil.getStr(levelName, "");
		time=ParamUtil.getStr(time, "");
		index=ParamUtil.getStr(index, "1");
		pageSize=ParamUtil.getStr(pageSize, "10");
		
		param.put("levelName", levelName);
		param.put("time", time);	
		param.put("index", index);
		param.put("pageSize", pageSize);	
		Map userInfo =(Map)request.getSession().getAttribute("loginInfo");
		String department="";
		 if(userInfo!=null){
			 department=userInfo.get("department").toString();
				if(department!=null && !"".equals(department)){
					param.put("department", department);	
					pageInfo=compeService.CompetitionList(param);
					
					resultMap.put("comPageInfo", pageInfo);
					System.out.println(param+"\n"+resultMap);
				}
		 }else{
			 System.out.println("还没有登录");
		 }
		
		
		
		return resultMap;
	}

	/**
	 * 获取近期的获奖---只能看自己系
	 * @param type
	 * time
	 *全部    本周      本月    三月内
	 *  
 	 * @return
	 */
	@ResponseBody
	@RequestMapping("/awardList")
	public  Map awardsList(String time,String index,String pageSize,HttpServletRequest request) {
		Map<String ,Object> resultMap=new HashMap<String, Object>();
		Map<String ,Object> param=new HashMap<String, Object>();
		PageInfo pageInfo=new PageInfo();
		
		time=ParamUtil.getStr(time, "");
		index=ParamUtil.getStr(index, "1");
		pageSize=ParamUtil.getStr(pageSize, "10");
		
		
		param.put("time", time);	
		param.put("index", index);	
		param.put("pageSize", pageSize);	
		Map userInfo =(Map)request.getSession().getAttribute("loginInfo");
		String department="";
		 if(userInfo!=null){
			 department=userInfo.get("department").toString();
				if(department!=null && !"".equals(department)){
					param.put("department", department);
					pageInfo=awardsService.getAwardsList(param);
					
					resultMap.put("awardsList", pageInfo);
					System.out.println(param+"\n"+resultMap);
				}
		 }
		return resultMap;
	}
	
	
	
	

	//---------文章相关
	//优化发布  将基础信息初始化贴到富文本框---竞赛   获奖
	/**
	 * 分页根据文章类型找到相关文章---只能查看自己发布的
	 * @param type 文章类型
	 * @param page 页数
	 * @param pageSize 每页数量 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/article")
	public  Map findArticleByType(String type,String index,String pageSize,HttpServletRequest request) {
		Map<String,Object> result=new HashMap<String, Object>();
		Map<String,Object> param=new HashMap<String, Object>();
		type=ParamUtil.getStr(type, "1");
		index=ParamUtil.getStr(index, "1");
		pageSize=ParamUtil.getStr(pageSize, "10");
		param.put("type", type);
		param.put("index", index);
		param.put("pageSize",pageSize);
		Map userInfo =(Map)request.getSession().getAttribute("loginInfo");
		String adminNo="";
		 if(userInfo!=null){
			 adminNo=userInfo.get("userId").toString();
				if(adminNo!=null && !"".equals(adminNo)){
					param.put("adminNo", adminNo);	
					PageInfo pageInfo=articleService.getArticleList(param);
					result.put("articlePageInfo",pageInfo );
				}
			}else{
				System.out.println("session信息丢失");
			}
		return result;
	}
	
	/**
	 * 发布文章
	 * @param title
	 * @param content
	 * @param articleType
	 * @param relationId
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/pubArticle")
	public String pubArticle(String title,String content,String articleType,String relationId,HttpServletRequest request) {
		String stateCode="0";
		 title=ParamUtil.getStr(title, "");
		 content=ParamUtil.getStr(content, "");
		 articleType=ParamUtil.getStr(articleType, "1");
		 int rid=0;
		 if(relationId!=null && !"".equals(relationId)){
			 rid= Integer.parseInt(relationId);
		 }
		 System.out.println(relationId+"------");
		 Map userInfo=(Map)request.getSession().getAttribute("loginInfo");
		 System.out.println("发布文章");
		 
		 String userNo="";
		 System.out.println(userInfo);
		 if(userInfo!=null){
			userNo=userInfo.get("userId").toString();
			if(userNo!=null && !"".equals(userNo)){
				Article article=new Article();
				article.setTitle(title);
				article.setContent(content);
				article.setRelationId(rid);
				article.setArticletype(Integer.parseInt(articleType));
				article.setPubdate(new Date());
				article.setPubuserno(userNo);
				System.out.println("article"+article);
				int state=articleService.insertArticle(article);
				if(state>0){
					stateCode="1";
				}
				System.out.println(article);
			}
		}else{
			System.out.println("session信息丢失");
		}
		 System.out.println(stateCode);
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
	
	
	
	/**
	 * 初始化文章内容
	 * @param comId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/initArticle")
	public Map initArticle(String comId, HttpServletResponse response){
		Map result=new HashMap<String,Object>();
		comId=ParamUtil.getStr(comId,"");
		String articleDetail="";
		      
		articleDetail=articleService.initArticleDetail(comId);
		response.setCharacterEncoding("UTF-8");  // 加上此处可解决页面js显示乱码问题    
		result.put("detail", articleDetail);
		return result ;
	}
	
	//---------作品相关
	
	/**
	 * 获取近期的优秀作品（可以报名）
	 * @param type
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/productionList")
 	public  Map productionList(String index,String pageSize,HttpServletRequest request) {
		Map<String ,Object> resultMap=new HashMap<String, Object>();
		Map<String ,Object> param=new HashMap<String, Object>();
		index=ParamUtil.getStr(index, "1");
		pageSize=ParamUtil.getStr(pageSize, "3");
		
		param.put("index", index);	
		param.put("pageSize", pageSize);	
		
		PageInfo<Production> pageInfo=new PageInfo<Production>();
		pageInfo=productionService.productioList(param);
		List<Production> list=pageInfo.getList();
		for(int i=0;i<list.size();i++){
			Production p=list.get(i);
			String fileName=p.getPic();
			String path = "productionImg";
			path=path+"/"+fileName;
			System.out.println(path);
			p.setPic(path);
			list.set(i, p);
		}
		pageInfo.setList(list);
		resultMap.put("produPageInfo", pageInfo);
		System.out.println(param+"\n"+resultMap);
		
		return resultMap;
	}
	
	/**
	 * 上传优秀作品
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@ResponseBody
	@RequestMapping("/uploadProduction")
	public Map uploadProduction(@RequestParam("file")MultipartFile file,String proName,String award,String membersName,String introduction, HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
		String stateCode="0";
		String info="上传作品失败";
		Map result=new HashMap<String, Object>();
		
		//上传图片 //进行转换  
        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)(request);  
        //获取所有文件名称  
        Iterator<String> it = multiRequest.getFileNames();  
        while(it.hasNext()){  
            //根据文件名称取文件  
            file = multiRequest.getFile(it.next());  
            String fileName = file.getOriginalFilename();  //文件名
            String uploadName = String.valueOf( System.currentTimeMillis());//时间戳字符串
            String fileType=fileName.substring(fileName.indexOf("."), fileName.length());
            if(".JPG".equals(fileType.toUpperCase()) ||".PNG".equals(fileType.toUpperCase())||".JPEG".equals(fileType.toUpperCase())){
            	uploadName=uploadName+fileType;
                
                String path = request.getSession().getServletContext().getRealPath("/productionImg");  
                path=path+"/"+uploadName;
                File newFile = new File(path);  
                //上传的文件写入到指定的文件中  
                file.transferTo(newFile);
                System.out.println("uploadName:"+uploadName);
                Production production=new Production();
        		production.setProname(proName);
        		production.setAward(award);
        		production.setMembersname(membersName);
        		production.setIntroduction(introduction);
        		production.setPic(uploadName);
        		production.setCreateDate(new Date());
        		System.out.println("production:"+production);
        		int state=productionService.insertProduction(production);
        		System.out.println(state);
        		if(state>0){
        			stateCode="1";
        			info="上传成功";
        		}
            }else{
            	info="不是作品图图片格式不对";
            	System.out.println("不是图片");
            }
        }
		result.put("stateCode", stateCode);
		result.put("info", info);
		return result;
	}
	
		/**
		 * 上传优秀作品
		 * @param request
		 * @param response
		 * @return
		 * @throws IOException 
		 * @throws IllegalStateException 
		 */
		@ResponseBody
		@RequestMapping("/updateProduction")
		public Map updateProduction(@RequestParam("file")MultipartFile file,String proId,String proName,String award,String membersName,String introduction, HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
			String stateCode="0";
			String info="上传作品失败";
			Map result=new HashMap<String, Object>();
			Production pro=productionService.findProByID(Integer.parseInt(proId));
			System.out.println(pro);
			//上传图片 //进行转换  
	        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)(request);  
	        //获取所有文件名称  
	        Iterator<String> it = multiRequest.getFileNames();
	        String uploadName ="";
	        while(it.hasNext()){  
	            //根据文件名称取文件  
	             file = multiRequest.getFile(it.next()); 
	            String fileName = file.getOriginalFilename();  //文件名
	            if(fileName!=null && fileName!=""){
	            //插入文件
	            uploadName = String.valueOf( System.currentTimeMillis());//时间戳字符串
	            String fileType=fileName.substring(fileName.indexOf("."), fileName.length());//文章后缀名
	            if(".JPG".equals(fileType.toUpperCase()) ||".PNG".equals(fileType.toUpperCase())||".JPEG".equals(fileType.toUpperCase())){
	            	uploadName=uploadName+fileType;
	                
	                String rootPath = request.getSession().getServletContext().getRealPath("/productionImg");  
	                String  path=rootPath+"/"+uploadName;
	                File newFile = new File(path);  
	                //上传的文件写入到指定的文件中  
	                file.transferTo(newFile);
	             //删除旧文件
	                String oldfile=rootPath+"/"+pro.getPic();
	                System.out.println(oldfile);
	                File file2=new File(oldfile);
	                if(file2.exists()){
	                	file2.delete();
	                }
	                
	                System.out.println("uploadName:"+uploadName);
	               
	            }else{
	            	info="不是作品图图片格式不对";
	            	System.out.println("不是图片");
	            }
	        }
	      }
	        Production production=new Production();
    		production.setProid(Integer.parseInt(proId));
    		production.setProname(proName);
    		production.setAward(award);
    		production.setMembersname(membersName);
    		production.setIntroduction(introduction);
    		production.setPic(uploadName);
    		System.out.println("production:"+production);
    		int state=productionService.updateProduction(production);
    		stateCode="1";
    		info="修改成功";
			result.put("stateCode", stateCode);
			result.put("info", info);
			return result;
		}

		
		/**
		 * 删除文章
		 * @param articleId
		 * @param relationId
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/deleteProduction")
		public int deleteProduction(int proId) {
			int stateCode=0;
			
			//获取当前登录用户
			 stateCode= productionService.delectProduction(proId);
			return stateCode;
		}
		
		
	//---------文件相关

	/**
	 * 文件上传
	 * @param request
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/uploadFile")
	public String saveFile(@RequestParam("file")MultipartFile file,HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
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
                 file = multiRequest.getFile(it.next());  
                String fileName = file.getOriginalFilename();  //文件名
                String uploadName = String.valueOf( System.currentTimeMillis());//时间戳字符串
                String fileType=fileName.substring(fileName.indexOf("."), fileName.length());
                uploadName=uploadName+fileType;
                
                String path = request.getSession().getServletContext().getRealPath("/uploadFile");  
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
		if(file!=null){
			String fileName=file.getSavename();
			System.out.println("fileName---"+fileName);
			String path = request.getSession().getServletContext().getRealPath("/uploadFile");  
			path+="/"+fileName;
			System.out.println("path:"+path);
			File deleteFile=new File(path);
			if(deleteFile.exists()){
				System.out.println("文件存在");
				deleteFile.delete();
			}
			//删除数据库
			int state=fileUploadService.deleteFile(fileID);
			System.out.println(state);
			if(state>0){
				statueCode="1";
			}
		}
        return statueCode;
	}
	
	/**
	 * 文件列表
	 * @param index
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/allFile")
	public Map allFile(String index,String pageSize,HttpServletRequest request){
		Map result=new HashMap<String,Object>();
		Map param=new HashMap<String,Object>();
		PageInfo pageinfo=new PageInfo();
		index=ParamUtil.getStr(index, "1");
		pageSize=ParamUtil.getStr(pageSize, "10");
		param.put("index",index);
		param.put("pageSize",pageSize);
		
		Map userInfo =(Map)request.getSession().getAttribute("loginInfo");
		String adminNo="";
		 if(userInfo!=null){
			 adminNo=userInfo.get("userId").toString();
				if(adminNo!=null && !"".equals(adminNo)){
					param.put("adminNo",adminNo);
					pageinfo=fileUploadService.allFile(param);
					result.put("filePage", pageinfo);
				}
		 }
		
		return result;
	}
	
	
	/**
	 * 所有的材料
	 * @param index
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/allMaterial")
	public Map allMaterial(String index,String pageSize,HttpServletRequest request){
		Map result=new HashMap<String,Object>();
		Map param=new HashMap<String,Object>();
		
		PageInfo pageinfo=new PageInfo();
		index=ParamUtil.getStr(index, "1");
		pageSize=ParamUtil.getStr(pageSize, "10");
		param.put("index",index);
		param.put("pageSize",pageSize);
		Map userInfo =(Map)request.getSession().getAttribute("loginInfo");
		String adminNo="";
		 if(userInfo!=null){
			 adminNo=userInfo.get("userId").toString();
			 param.put("adminNo", adminNo);
			 
			 pageinfo =adminImpl.allMaterial(param);
				result.put("materials", pageinfo);
		 }
		
		
		return result;
	}
	
	
	/**
	 * 审核材料
	 * @param index
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/reviewMaterial")
	public Map reviewMaterial(String mid,String pass){
		Map result=new HashMap<String,Object>();
		int  stateCode=0;
		int id=Integer.parseInt(ParamUtil.getStr(mid, "0"));
		int state=Integer.parseInt(ParamUtil.getStr(pass, "1"));
		if(state==0){
			state=-1;
		}
		stateCode=adminImpl.updateMaterialState(id,state);
		result.put("stateCode", stateCode);
		return result;
	}
	
	
	/**
	 * 获取所有未发布的竞赛，获取所有未发布的获奖
	 * type 1--竞赛   2---获奖
	 */
	@ResponseBody
	@RequestMapping("/unPub")
	public List unPub(String type,HttpServletRequest request){
		type=ParamUtil.getStr(type, "");
		List list=new ArrayList<Map>();
		System.out.println(type+"===");
		Map userInfo =(Map)request.getSession().getAttribute("loginInfo");
		String department="";
		 if(userInfo!=null){
			 department=userInfo.get("department").toString();
				if(department!=null && !"".equals(department)){
					if("1".equals(type)){
						//竞赛
						System.out.println(type+"----");
						list=compeService.unPubCom(department);
					}else if("2".equals(type)){
						//获奖情况
						list=awardsService.unPubAward(department);
					}
					
				}
		 }
		
		return list;
		
	}
/**
 * 获取所有的模板
 * @param index 当前页
 * @param pageSize 每页数量
 * @return
 */
	@ResponseBody
	@RequestMapping("/allModel")
	public PageInfo getAllModel(String index,String pageSize){
		PageInfo<Map> model=new PageInfo<Map>();
		Map map=new HashMap<String, Object>();
		index=ParamUtil.getStr(index, "1");
		pageSize=ParamUtil.getStr(pageSize, "10");
		map.put("index", index);
		map.put("pageSize", pageSize);
		model=modelService.getAllModel(map);
		
		return model;
	}

	/**
	 * 添加一个Model
	 * @param content 模板内容 
	 * @param adminNo 添加模板的管理员账号
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addModel")
	public int addModel(String content,String adminNo){
		
		Model model=new Model();
		model.setContent(content);
		model.setAdminNo(adminNo);
		int row=modelService.insertModel(model);
		return row;
	}
	
	/**
	 * 修改模板Model
	 * @param content 模板内容 
	 * @param mid 模板id 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateModel")
	public int updateModel(String content,String mid){
		int modelid=Integer.parseInt(mid);
		Model model=new Model();
		model.setContent(content);
		model.setMid(modelid);
		int row=modelService.updateModel(model);
		return row;
	}
	
	/**
	 * 删除模板Model
	 * @param mid 模板id 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteModel")
	public int deleteModel(int mid){
		int row=modelService.delectModel(mid);
		return row;
	}
	
	/**
	 * 
	 * @param mid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/awardsByComp")
	public List awardsByComp(String compId){
		List<Map> resuList=new ArrayList<Map>();
		int compid=Integer.parseInt(ParamUtil.getStr(compId, "0"));
		if(compid>0){
			resuList =awardsService.awardsByComp(compid);
		}
		return resuList;
	}
	
}
