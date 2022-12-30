package Cau2;

import java.util.*;

import Cau1.Housing;
import Cau1.Product;

public class HousingManagerImpl implements HousingManager {
	private List<Housing> list = new ArrayList<>();

	private static int autoNumber = 101;
	
	static Scanner sc = new Scanner(System.in);

	public void init() {
		list.add(new Housing(autoNumber++, "Chung cư mini", 100000, 5, 20, "Hà Đông"));
		list.add(new Housing(autoNumber++, "Chung cư", 900000, 6, 40, "Hà Nội"));
		list.add(new Housing(autoNumber++, "Chung cư cao cấp", 2400000, 4, 45, "Mỹ Đình"));
		list.add(new Housing(autoNumber++, "Nhà view Hồ Tây", 5000000, 6, 35, "Nhổn"));
		list.add(new Housing(autoNumber++, "VinHome", 4000000, 5, 20, "Gia Lâm"));
	}

	@Override
	public boolean addHousing(Housing h) {
		h.input();
		if (list.contains(h)) {
			return false;
		}
		h.setProduct_id(autoNumber++);
		list.add(h);
		System.out.println("\tThêm thành công");
		return true;
	}

	@Override
	public boolean editHousing(Housing h) {
		System.out.print("\tNhập mã (id) bđs cần sửa: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOf(id);
		System.out.println(index);
		if (index == -1) {
			System.out.println("\tBĐS không có trong danh sách!");
			return false;
		}
		h.input();
		h.setProduct_id(list.get(index).getProduct_id());
		list.set(index, h);
		System.out.println("Sửa thành công!");
		return true;
	}

	@Override
	public boolean delHousing(Housing h) {
		System.out.print("\tNhập mã (id) bđs cần xóa: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOf(id);
		if (index == -1) {
			System.out.println("\tBĐS không có trong danh sách!");
			return false;
		}
		list.remove(index);
		System.out.println("Xóa thành công!");
		return true;
	}

	@Override
	public List<Housing> searchHousing(String name) {
		List<Housing> search = new ArrayList<>();
		for (Housing housing : list) {
			if (housing.getProduct_name().toLowerCase().contains(name.toLowerCase())) {
				search.add(housing);
			}
		}
		return search;
	}

	@Override
	public List<Housing> searchHousing(double product_price) {
		List<Housing> search = new ArrayList<>();
		for (Housing housing : list) {
			if (housing.getProduct_price() == product_price) {
				search.add(housing);
			}
		}
		return search;
	}

	@Override
	public List<Housing> searchHousingByArea(double area) {
		List<Housing> search = new ArrayList<>();
		for (Housing housing : list) {
			if (housing.getArea() == area) {
				search.add(housing);
			}
		}
		return search;
	}

	@Override
	public List<Housing> searchHousingByLocation(String location) {
		List<Housing> search = new ArrayList<>();
		for (Housing housing : list) {
			if (housing.getLocation().compareToIgnoreCase(location) == 0) {
				search.add(housing);
			}
		}
		return search;
	}

	@Override
	public List<Housing> sortedHousing(double price) {
		List<Housing> tmp = new ArrayList<>();
		for (Housing housing : list) {
			if(housing.getProduct_price() > price) {
				tmp.add(housing);
			}
		}
		int i;
		do {
			System.out.print("Nhập vào kiểu sắp xếp(1: tăng, 0: giảm)");
			i = Integer.parseInt(sc.nextLine());
			if(i == 1) {
				Collections.sort(tmp, new sortedByPrice());
			} else {
				Collections.sort(tmp, new sortedByPrice().reversed());
			}
		} while(i != 1 && i != 0);

		return tmp;
	}

	@Override
	public List<Housing> sortedHousingByArea(double area) {
		List<Housing> tmp = new ArrayList<>();
		for (Housing housing : list) {
			if(housing.getArea() > area) {
				tmp.add(housing);
			}
		}
		int i;
		do {
			System.out.print("Nhập vào kiểu sắp xếp(1: tăng, 0: giảm)");
			i = Integer.parseInt(sc.nextLine());
			if(i == 1) {
				Collections.sort(tmp, new sortedByArea());
			} else {
				Collections.sort(tmp, new sortedByArea().reversed());
			}
		} while(i != 1 && i != 0);

		return tmp;
	}
	
	public int indexOf(int id) {
		for (int index = 0; index < list.size(); index++)
			if (list.get(index).getProduct_id() == id)
				return index;

		return -1;
	}
	
	public void show() {
		System.out.println(list);
	}

}

class sortedByPrice implements Comparator<Housing> {

	@Override
	public int compare(Housing o1, Housing o2) {
		// TODO Auto-generated method stub
		Double price1 = o1.getProduct_price();
		Double price2 = o2.getProduct_price();
		return (int) (price1 - price2);
	}

}

class sortedByArea implements Comparator<Housing> {

	@Override
	public int compare(Housing o1, Housing o2) {
		// TODO Auto-generated method stub
		double area1 = o1.getArea();
		double area2 = o2.getArea();
		return (int) (area1 - area2);
	}

}
