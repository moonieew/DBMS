package vn.shopthethao.Service;

import java.util.List;

import vn.shopthethao.Model.BrandModel;

public interface BrandService {
	void insert(BrandModel brand); // Thêm thương hiệu
	void edit(BrandModel brand); // Sửa thương hiệu
	void delete(BrandModel brand); // Xoá thương hiệu
	List<BrandModel> getAllBrand(); // Lấy toàn bộ thương hiệu
}
