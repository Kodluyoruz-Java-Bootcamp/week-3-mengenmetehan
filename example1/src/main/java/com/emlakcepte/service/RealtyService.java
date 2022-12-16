package com.emlakcepte.service;

import com.emlakcepte.model.enums.ProvinceNames;
import com.emlakcepte.model.enums.RealtyAccountType;
import com.emlakcepte.model.Realty;
import com.emlakcepte.model.User;
import com.emlakcepte.model.enums.RealtyType;
import com.emlakcepte.model.enums.UserType;
import com.emlakcepte.repository.RealtyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealtyService {

	private RealtyRepository realtyDao = new RealtyRepository();



	public boolean createRealty(Realty realty)
	{

		//Bireysel kullanıcılar sadece konut türünden ve 3 adet ilan verebilir
		if (UserType.INDIVIDUAL.equals(realty.getUser().getType())) {
			if (!realty.getUser().getType().equals(RealtyType.HOUSE)) {
				System.out.println("Bireysel kullanıcılar sadece konut ilanı verebilir");
				return false;
			}
			if (realty.getUser().getRealtyList().size() >= 3) {
				System.out.println("Bireysel kullanıcılar sadece 3 adet ilan verebilir");
				return false;
			}
		}
		return true;
	}

	public List<Realty> getAll() {
		return realtyDao.findAll();
	}

	public void printAll(List<Realty> realtList) {
		realtList.forEach(realty -> System.out.println(realty));
	}

	public void getAllByProvince(String province) {

		getAll().stream().filter(realty -> realty.getProvince().equals(province))
				// .count();
				.forEach(realty -> System.out.println(realty));

	}

	public List<Realty> getAllByProvinceAndDistrict(String province, String district)
	{
		return getAll().stream()
				.filter(r -> r.getProvince().equals(province))
				.filter(r -> r.getDistrict().equals(district))
				.toList();
	}

	public List<Realty> getAllByUserName(User user) {
		return getAll().stream().filter(realty -> realty.getUser().getMail().equals(user.getMail())).toList();
	}

	public List<Realty> getActiveRealtyByUserName(User user) {

		return getAll().stream()
				.filter(realty -> realty.getUser().getName().equals(user.getName()))
				.filter(realty -> RealtyAccountType.ACTIVE.equals(realty.getStatus()))
				.toList();

	}

	// Şehir ve ilçe bazlı ilan arama
	public List<Realty> getAllByDistrict(String province, String district)
	{
		return getAll().stream()
				.filter(realty -> realty.getProvince().equals(province))
				.filter(realty -> realty.getProvince().equals(district))
				.toList();
	}

	public List<Realty> getAllAtIstanbulProvince() {

		return getAll().stream()
				.filter(realty -> realty.getProvince().equals(ProvinceNames.ISTANBUL))
				.limit(10)
				.toList();
	}

	public List<Realty> getAllAtAnkaraProvince() {

		return getAll().stream()
				.filter(realty -> realty.getProvince().equals(ProvinceNames.ANKARA))
				.limit(10)
				.toList();
	}

	public List<Realty> getAllAtIzmirProvince() {

		return getAll().stream()
				.filter(realty -> realty.getProvince().equals(ProvinceNames.IZMIR))
				.limit(10)
				.toList();
	}

	//Şehirdeki ilan sayıları
	public long countOfIstanbulProvince() {

		return getAll().stream()
				.filter(realty -> realty.getProvince().equals(ProvinceNames.ISTANBUL))
				.count();
	}

	public long countOfAnkaraProvince() {

		return getAll().stream()
				.filter(realty -> realty.getProvince().equals(ProvinceNames.ANKARA))
				.count();
	}

	public long countOfIzmirProvince() {

		return getAll().stream()
				.filter(realty -> realty.getProvince().equals(ProvinceNames.IZMIR))
				.count();
	}

	//Şehirdeki satılık ilan sayıları
	public long countOfSalesIstanbulProvince()
	{

		return getAll().stream()
				.filter(realty -> realty.getProvince().equals(ProvinceNames.ISTANBUL))
				.filter(realty -> realty.isSale())
				.count();
	}

	public long countOfSalesAnkaraProvince() {

		return getAll().stream()
				.filter(realty -> realty.getProvince().equals(ProvinceNames.ANKARA))
				.filter(realty -> realty.isSale())
				.count();
	}

	public long countOfSalesIzmirProvince() {

		return getAll().stream()
				.filter(realty -> realty.getProvince().equals(ProvinceNames.IZMIR))
				.filter(realty -> realty.isSale())
				.count();
	}

}
