package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Items;

public interface ItemsService {
	List<Items> findAllItems();

	Items findItemsById(Integer id);

	void saveItem(Items items);

}
