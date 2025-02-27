package com.my.pro.action;

import java.util.HashMap;
import org.springframework.beans.BeanUtils;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.my.pro.utils.Pager;
import com.opensymphony.xwork2.ModelDriven;
import java.util.*;

import com.my.pro.model.*;
import com.my.pro.dao.*;
import com.my.pro.service.*;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * 
 */

@Controller("commentAction")
@Scope("prototype")
public class CommentAction extends BaseAction implements ModelDriven<Comment>{
	
	private static final long serialVersionUID = 1L;


	
	//==========model==============
	  private Comment comment;
		@Override
		public Comment getModel() {
			if(comment==null) comment = new Comment();
			return comment;	
		}
		//==========model==============
	/**
	 * 依赖注入 start dao/service/===
	 */
	@Autowired
	private CommentService commentService;
	
	//依赖注入 end  dao/service/===
	
	//-------------------------华丽分割线---------------------------------------------
	
	//============自定义参数start=============
	
	//============自定义参数end=============

	
	//-------------------------华丽分割线---------------------------------------------
	
	//============文件上传start=======================================================
	
	
	private File file;
	//提交过来的file的名字
    private String fileFileName;
    //提交过来的file的MIME类型
    private String fileContentType;
    public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	 //============文件上传end=========================================================
	public String jsonAction() {
		  // dataMap中的数据将会被Struts2转换成JSON字符串，所以这里要先清空其中的数据
		  jsonMap.clear();
		  jsonMap.put("success", true);
		  return JSON_TYPE;
	}
	 //-------------------------华丽分割线---------------------------------------------//
	
	 //=============公=======共=======方=======法==========区=========start============//
	/**
	 * 列表分页查询 and isDelete = 0 
	 * 
	 */
	public String comment(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from Comment where 1=1 ");
		if(comment.getUser()!=null && comment.getUser().getRealName() !=null && !"".equals(comment.getUser().getRealName())){
			sb.append("  and user.realName like :realName ");
			alias.put("realName", "%" +comment.getUser().getRealName()+ "%" );
		}
		sb = sb.append("order by id desc");
		Pager<Comment> pagers = commentService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", comment);
		return SUCCESS;
    }
	
	/**
	 * 跳转到添加页面
	 * @return
	 */
	public String add(){
		return SUCCESS;
	}
	
	/**
	 * 执行添加
	 * @return
	 */
	public String exAdd(){
		commentService.save(comment);
		ActionContext.getContext().put("url", "/comment_comment.do");
		return "redirect";
	}
	
	/**
	 * 查看详情页面
	 * @return
	 */
	public String view(){
		Comment n = commentService.getById(comment.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
	
	/**
	 * 跳转修改页面
	 * @return
	 */
	public String update(){
		Comment n = commentService.getById(comment.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
    
	/**
	 * 执行修改
	 * @return
	 */
	public String exUpdate(){
		Comment n = commentService.getById(comment.getId());
		BeanUtils.copyProperties(comment, n, getNullPropertyNames(comment));
		commentService.update(n);
		ActionContext.getContext().put("url", "/comment_comment.do");
		return "redirect";
	}
	
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		//commentService.delete(comment.getId());
		Comment n = commentService.getById(comment.getId());
		//n.setIsDelete(1);
		commentService.update(n);
		ActionContext.getContext().put("url", "/comment_comment.do");
		return "redirect";
	}
	
	//=============公=======共=======方=======法==========区=========end============//
	
	 //-------------------------华丽分割线---------------------------------------------//
	
	 //=============自=======定=======义=========方=======法==========区=========start============//
	
	
	
	
	//=============自=======定=======义=========方=======法==========区=========end============//
		
	
	
}
