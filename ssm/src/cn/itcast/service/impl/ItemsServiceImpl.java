package cn.itcast.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.dao.ItemsMapper;
import cn.itcast.domain.Items;
import cn.itcast.service.ItemsService;

@Service
public class ItemsServiceImpl implements ItemsService {
	
	@Resource
	private ItemsMapper itemsMapper;
	
	public List<Items> findAllItems() {
		List<Items> list = itemsMapper.findAllItems();
		return list;
	}

	@Override
	public Items findItemsById(Integer id) {
		Items items = itemsMapper.selectByPrimaryKey(id);
		return items;
	}

	@Override
	public void saveItem(Items items) {
		itemsMapper.updateByPrimaryKeySelective(items);
	}
	
}
