package Cau2;

import java.util.List;
import Cau1.Housing;

public interface HousingManager {
	public boolean addHousing(Housing h);
	public boolean editHousing(Housing h);
	public boolean delHousing(Housing h);
	public List< Housing> searchHousing(String name);
	public List< Housing> searchHousing(double product_price);
	public List< Housing> searchHousingByArea(double area);
	public List< Housing> searchHousingByLocation(String location);
	public List<Housing> sortedHousing(double price);
	public List<Housing> sortedHousingByArea(double area);
}
