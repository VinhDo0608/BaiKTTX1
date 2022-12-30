import Cau1.Housing;
import Cau2.HousingManagerImpl;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		HousingManagerImpl manager = new HousingManagerImpl();
		manager.init();
		Housing housing = new Housing();
		do {
			System.out.println("\n\t----------------------------Menu---------------------------");
			System.out.println("\t1. Add housing");
			System.out.println("\t2. Edit housing");
			System.out.println("\t3. Del housing");
			System.out.println("\t4. Search housing by name");
			System.out.println("\t5. Search housing by price");
			System.out.println("\t6. Search housing by area");
			System.out.println("\t7. Search housing by location");
			System.out.println("\t8. Sorted housing by price");
			System.out.println("\t9. Sorted housing by area");
			System.out.println("\t10. Show list");
			System.out.println("\t0. Exit");
			System.out.println("\t-----------------------------End-----------------------------");

			Scanner sc = new Scanner(System.in);
			System.out.print("Nhập lựa chọn của bạn: ");
			int choise = sc.nextInt();
			
			switch (choise) {
			case 1:
				manager.addHousing(housing);
				break;
			case 2:
				manager.editHousing(housing);
				break;
			case 3:
				manager.delHousing(housing);
				break;
			case 4:
				System.out.print("Nhập name: ");
				System.out.print(manager.searchHousing(new Scanner(System.in).nextLine()));
				break;
			case 5:
				System.out.print("Nhập giá: ");
				System.out.print(manager.searchHousing(Double.parseDouble(new Scanner(System.in).nextLine())));
				break;
			case 6:
				System.out.print("Nhập diện tích: ");
				System.out.print(manager.searchHousingByArea(Double.parseDouble(new Scanner(System.in).nextLine())));
				break;
			case 7:
				System.out.print("Nhập khu vực: ");
				System.out.print(manager.searchHousingByLocation(new Scanner(System.in).nextLine()));
				break;
			case 8:
				System.out.print("Nhập giá min($): ");
				System.out.print(manager.sortedHousing(Double.parseDouble(new Scanner(System.in).nextLine())));
				break;
			case 9:
				System.out.print("Nhập diện tích min(m²): ");
				System.out.print(manager.sortedHousingByArea(Double.parseDouble(new Scanner(System.in).nextLine())));
				break;
			case 10:
				manager.show();
				break;
			case 0:
				System.out.println("Thoát hệ thống thành công!");
				return;
			default:
				System.out.println("Lựa chọn không hợp lệ!");
			}
		} while (true);

	}
}
