package vn.shopthethao.Service.Impl;

import java.util.List;

import vn.shopthethao.DAO.BrandDAO;
import vn.shopthethao.DAO.Impl.BrandDAOImpl;
import vn.shopthethao.Model.BrandModel;
import vn.shopthethao.Service.BrandService;


public class BrandServiceImpl implements BrandService{
	BrandDAO brandDAO = new BrandDAOImpl(); 
	@Override
	public void insert(BrandModel brand) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(BrandModel brand) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(BrandModel brand) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BrandModel> getAllBrand() {
		return brandDAO.getAllBrand();
	}

}
