package cn.itcast.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.domain.Items;
import cn.itcast.service.ItemsService;

@Controller
@RequestMapping("/items")
public class ItemsController {
	@Resource
	private ItemsService itemsService;
	@RequestMapping("index")
	public String index() {
		return "index";
	}
	@RequestMapping("findAllItems")
	public String findAllItems(Model model) {
		List<Items> itemsList = itemsService.findAllItems();
		//把集合放入model进行回显
		model.addAttribute("itemsList",itemsList);
		return "itemsList";
	}
	@RequestMapping("editItem")
	public String editItem(Model model,Integer id) {
		Items items = itemsService.findItemsById(id);
		model.addAttribute("item", items);
		return "editItem";
	}
	@RequestMapping("saveItem")
	public String saveItem(Items items) {
		itemsService.saveItem(items);
		return "redirect:findAllItems.do";
	}
	@InitBinder
	protected void init(HttpServletRequest request,ServletRequestDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	@RequestMapping(value="/{formName}")
	public String loginname(@PathVariable String formName,Model model) {
		model.addAttribute("hello","你好，你是最棒的");
		return formName;
	}
}
