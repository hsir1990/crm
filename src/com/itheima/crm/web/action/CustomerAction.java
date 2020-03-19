package com.itheima.crm.web.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.io.FileUtils;
import org.hibernate.criterion.DetachedCriteria;

import com.itheima.crm.domain.Customer;
import com.itheima.crm.domain.PageBean;
import com.itheima.crm.service.CustomerService;
import com.itheima.crm.service.utils.UploadUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	//模型驱动使用的对象
	private Customer customer = new Customer();
	
	@Override
	public Customer getModel() {
		return customer;
	}
	
	//注入Service
	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
		
	//客户管理：跳转到添加页面的方法
	public String saveUI() {
		System.out.println("12------1");
		return "saveUI";
	}
	//文件上传提供的三个属性：
	private String uploadFileName;//文件名称
	private File upload;//上传文件
	private String uploadContentType;//文件类型
		
		
		
		
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	//保存客户
	public String save() throws IOException {
		//图片上传
		if(upload!=null) {
			//文件上传
			//设置文件上传的路径
			String path = "/Users/dongmian/hsir/java/imgs";
			//一个目录下存放的相同的文件名：随即文件名
			String uuidFileName = UploadUtils.getUuidFileName(uploadFileName);
			//一个目录下存放的文件过多：目录分离
			String realPath = UploadUtils.getPath(uuidFileName);
			//创建目录
			String url = path+realPath;
			File file = new File(url);
			if(!file.exists()) {
				file.mkdirs();
			}
			
			//文件上传
			File dictFile = new File(url + "/" +uuidFileName);
			FileUtils.copyFile(upload, dictFile);
			customer.setCust_image(url + "/" +uuidFileName);
		}
		customerService.save(customer);
		System.out.println("1--22--1");
		return "saveSuccess";
	}
	
	//使用set方法接收数据
	private Integer currPage = 1;
	//客户列表
	public void setCurrPage(Integer currPage) {
		if(currPage == null) {
			currPage = 1;
		}
		this.currPage = currPage;
	}
	//使用set方法接收每页显示记录页
	private Integer pageSize = 3;
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String findAll() {
	
		//	接受分页参数
		//最好使用DetachedCriteria对象（条件查询带分页）
		DetachedCriteria  detachedCriteria = DetachedCriteria.forClass(Customer.class);
		//调用业务层查询
		PageBean<Customer> pageBean = customerService.findByPage(detachedCriteria, currPage, pageSize);
		
		ActionContext.getContext().getValueStack().push(pageBean);
		
		return "findAll";
	}

	

}
