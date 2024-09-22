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
import com.my.pro.utils.UserUtils;
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

@Controller("kzAction")
@Scope("prototype")
public class KzAction extends BaseAction implements ModelDriven<Kz>{
	
	private static final long serialVersionUID = 1L;


	
	//==========model==============
	  private Kz kz;
		@Override
		public Kz getModel() {
			if(kz==null) kz = new Kz();
			return kz;	
		}
		//==========model==============
	/**
	 * 依赖注入 start dao/service/===
	 */
	@Autowired
	private KzService kzService;
	
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
	public String kz(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from Kz where 1=1 and isDelete = 0 ");
		sb = sb.append("order by id desc");
		Pager<Kz> pagers = kzService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", kz);
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
		kzService.save(kz);
		ActionContext.getContext().put("url", "/kz_kz.do");
		return "redirect";
	}
	
	/**
	 * 查看详情页面
	 * @return
	 */
	public String view(){
		Integer loginId = UserUtils.getLoginId();
		if(loginId == null){
			ActionContext.getContext().put("url", "/login_login.do");
			return "redirect";
		}
		Kz n = kzService.getById(kz.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
	
	/**
	 * 跳转修改页面
	 * @return
	 */
	public String update(){
		Kz n = kzService.getById(kz.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
    
	/**
	 * 执行修改
	 * @return
	 */
	public String exUpdate(){
		Kz n = kzService.getById(kz.getId());
		BeanUtils.copyProperties(kz, n, getNullPropertyNames(kz));
		kzService.update(n);
		ActionContext.getContext().put("url", "/kz_kz.do");
		return "redirect";
	}
	
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		//kzService.delete(kz.getId());
		Kz n = kzService.getById(kz.getId());
		n.setIsDelete(1);
		kzService.update(n);
		ActionContext.getContext().put("url", "/kz_kz.do");
		return "redirect";
	}
	
	public String dz(){
		Integer loginId = UserUtils.getLoginId();
		if(loginId == null){
			ActionContext.getContext().put("url", "/login_login.do");
			return "redirect";
		}
		Kz n = kzService.getById(kz.getId());
		n.setDzNum(n.getDzNum()+1);
		kzService.update(n);
		ActionContext.getContext().put("url", "/kz_view.do?id="+kz.getId());
		return "redirect";
	}
	
	//=============公=======共=======方=======法==========区=========end============//
	
	 //-------------------------华丽分割线---------------------------------------------//
	
	 //=============自=======定=======义=========方=======法==========区=========start============//
	
	
	
	
	//=============自=======定=======义=========方=======法==========区=========end============//
		
	
	
}
