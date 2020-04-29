package Businessapp;
import java.util.Scanner;
public class Businessapp {
	private Company company;
	private Scanner in;
	public Businessapp() {
		company=new Company();
	    in=new Scanner(System.in);
	}
	public void menu() {
		String input="-1";
		while(!input.equals("0")){
			System.out.println("Please enter the operation number that you want to perform");
			System.out.println("1) Buy product \n2) Transport a container \n3) Produce product \n4) Sell product \n5) Show products and ingredients in facilities \n0) Exit");
			input = in.nextLine();
			if(input.equals("1")) {
				System.out.println("Please enter ingredient number(1:Cream, 2:Milk, 3:Yeast, 4:Cacao):");
				input=in.nextLine();
				if(input.equals("1")) {
				System.out.println("Enter amount ingredient you want to buy");
				double amount=in.nextDouble();
				company.buyIngredient("Cream", amount);	
				}
				else if(input.equals("2")) {
					System.out.println("Enter amount ingredient you want to buy");
					double amount=in.nextDouble();
					company.buyIngredient("Milk", amount);	
				}
				else if(input.equals("3")) {
					System.out.println("Enter amount ingredient you want to buy");
					double amount=in.nextDouble();
					company.buyIngredient("Yeast", amount);
				}	
				else if(input.equals("4")) {
					System.out.println("Enter amount ingredient you want to buy");
					double amount=in.nextDouble();
					company.buyIngredient("Cacao", amount);	
				}
				System.out.println("Profit= "+ company.companyProfit());
			}
			else if(input.equals("2")) { // transport a container
				company.printContainerInfo();
				System.out.println("Enter container you want to choose (1:Dry Storage, 2:Open Top, 3:Tank):");
				String container=in.nextLine();
				if(container.equals("1")) {
					System.out.println("Enter your destination (1:Warehouse, 2:Factory, 3:Center):");
					String destination=in.nextLine();
					if(destination.equals("1")) {
						System.out.println("If you want to load ingredient or product enter 1,for no operation 2");
						input=in.nextLine();
						if(input.equals("1")) {
							chooseContainerandAmount("Dry Storage");
							company.transferContainer("Dry Storage", "Warehouse");
							System.out.println("If you want to unload container in destination enter 1: ");
							String choice=in.nextLine();
							choice=in.nextLine();
							if(choice.equals("1")) {
								company.unloadContainer("Dry Storage");
							}
						}
						else if(input.equals("2")) {
							company.transferContainer("Dry Storage", "Warehouse");
						}						
					}					
					else if(destination.equals("2")) {
						System.out.println("If you want to load ingredient or product enter 1,for no operation 2");
						input=in.nextLine();
						if(input.equals("1")) {
							System.out.println("Enter the item you want to carry (1:Cacao, 2:Cream, 3:Milk, 4:Yeast):");
							String item=in.nextLine();
							System.out.println("Enter the amount you want to carry");
							double amount=in.nextDouble();
							if(item.equals("1")) {
								company.loadContainer("Dry Storage", "Cacao",amount);	
							}
							else if(item.equals("2")) {
								company.loadContainer("Dry Storage", "Cream",amount);	
							}
							else if(item.equals("3")) {
								company.loadContainer("Dry Storage", "Milk",amount);	
							}
							else if(item.equals("4")) {
								company.loadContainer("Dry Storage", "Yeast",amount);	
							}	
							company.transferContainer("Dry Storage", "Factory");
							System.out.println("If you want to unload container in destination enter 1: ");
							String choice=in.nextLine();
							choice=in.nextLine();
							if(choice.equals("1")) {
								company.unloadContainer("Dry Storage");
							}
						}	
						else if(input.equals("2")) {
							company.transferContainer("Dry Storage", "Factory");
						}
					}
					else if(destination.equals("3")) {
						System.out.println("If you want to load ingredient or product enter 1,for no operation 2");
						input=in.nextLine();
						if(input.equals("1")) {
							chooseContainerandProductAmount("Dry Storage");
							company.transferContainer("Dry Storage", "Center");
							System.out.println("If you want to unload container in destination enter 1: ");
							String choice=in.nextLine();
							choice=in.nextLine();
							if(choice.equals("1")) {
								System.out.println("burdaa");
								company.unloadContainer("Dry Storage");
							}
						}
						else if(input.equals("2")) {
							company.transferContainer("Dry Storage", "Center");
						}
					}
				}
				else if(container.equals("2")) {
					System.out.println("Enter your destination (1:Warehouse, 2:Factory, 3:Center):");	
					String destination=in.nextLine();
					if(destination.equals("1")) {
						System.out.println("If you want to load ingredient or product enter 1,for no operation 2");
						input=in.nextLine();
						if(input.equals("1")) {
							chooseContainerandAmount("Open Top");
							company.transferContainer("Open Top", "Warehouse");
							System.out.println("If you want to unload container in destination enter 1: ");
							String choice=in.nextLine();
							if(choice.equals("1")) {
								company.unloadContainer("Open Top");
							}
						}
						else if(input.equals("2")) {
							company.transferContainer("Open Top", "Warehouse");
						}	
					}
					else if(destination.equals("2")) {
						System.out.println("If you want to load ingredient or product enter 1,for no operation 2");
						input=in.nextLine();
						if(input.equals("1")) {
							chooseContainerandAmount("Open Top");
							company.transferContainer("Open Top", "Factory");
							System.out.println("If you want to unload container in destination enter 1: ");
							String choice=in.nextLine();
							choice=in.nextLine();
							if(choice.equals("1")) {
								company.unloadContainer("Open Top");
							}
						}
						else if(input.equals("2")) {
							company.transferContainer("Open Top", "Factory");
						}		
					}
					else if(destination.equals("3")) {
						System.out.println("If you want to load ingredient or product enter 1,for no operation 2");
						input=in.nextLine();
						if(input.equals("1")) {
							chooseContainerandAmount("Open Top");
							company.transferContainer("Open Top", "Center");
							System.out.println("If you want to unload container in destination enter 1: ");
							String choice=in.nextLine();
							choice=in.nextLine();
							if(choice.equals("1")) {
								company.unloadContainer("Open Top");
							}
						}
						else if(input.equals("2")) {
							company.transferContainer("Open Top", "Center");
						}				
					}
				}
				else if(container.equals("3")) {
					System.out.println("Enter your destination (1:Warehouse, 2:Factory, 3:Center):");	
					String destination=in.nextLine();			
					if(destination.equals("1")) {
						System.out.println("If you want to load ingredient or product enter 1,for no operation 2");
						input=in.nextLine();
						if(input.equals("1")) {
							chooseContainerandAmount("Tank");	
							company.transferContainer("Tank", "Warehouse");
							System.out.println("If you want to unload container in destination enter 1: ");
							String choice=in.nextLine();
							choice=in.nextLine();
							if(choice.equals("1")) {
								company.unloadContainer("Tank");
							}
						}
						else if(input.equals("2")) {
							company.transferContainer("Tank", "Warehouse");
						}		
					}
					else if(destination.equals("2")) {
						System.out.println("If you want to load ingredient or product enter 1,for no operation 2");
						input=in.nextLine();
						if(input.equals("1")) {
							chooseContainerandAmount("Tank");	
							company.transferContainer("Tank", "Factory");	
							System.out.println("If you want to unload container in destination enter 1: ");
							String choice=in.nextLine();
							choice=in.nextLine();			
							if(choice.equals("1")) {
								company.unloadContainer("Tank");
							}
						}
						else if(input.equals("2")) {
							company.transferContainer("Tank", "Factory");
						}	
					}
					else if(destination.equals("3")) {
						System.out.println("If you want to load ingredient or product enter 1,for no operation 2");
						input=in.nextLine();
						if(input.equals("1")) {
							chooseContainerandAmount("Tank");	
							company.transferContainer("Tank", "Center");
							System.out.println("If you want to unload container in destination enter 1: ");
							String choice=in.nextLine();
							choice=in.nextLine();
							if(choice.equals("1")) {
								company.unloadContainer("Tank");
							}
						}
						else if(input.equals("2")) {
							company.transferContainer("Tank", "Center");
						}		
					}
				}			
				System.out.println("Profit= "+ company.companyProfit());
			}
			else if(input.equals("3")) {
				System.out.println("Enter the product you want to produce (1:Boxed Milk, 2:Chocolate, 3:Yoghurt)");
				String product=in.nextLine();
				if(product.equals("1")) {
					company.produceProduct("Boxed Milk");
				}
				else if(product.equals("2")) {
					company.produceProduct("Chocolate");
				}
				else if(product.equals("3")) {
					company.produceProduct("Yoghurt");
				}
				System.out.println("Profit= "+ company.companyProfit());
			}
			else if(input.equals("4")) {
				System.out.println("Enter the name of the product you want to sell (1:Boxed Milk, 2:Chocolate, 3:Yoghurt):");
				String product=in.nextLine();
				if(product.equals("1")) {
					System.out.println("Enter the amount ");
					int amount=in.nextInt();
					company.sellProduct("Boxed Milk", amount);
				}
				else if(product.equals("2")) {
					System.out.println("Enter the amount ");
					int amount=in.nextInt();
					company.sellProduct("Chocolate", amount);
				}
				else if(product.equals("3")) {
					System.out.println("Enter the amount ");
					int amount=in.nextInt();
					company.sellProduct("Yoghurt", amount);
				}
				System.out.println("Profit= "+ company.companyProfit());			}
			else if(input.equals("5")) {
				System.out.println("Enter a facility that you want to see(1:Warehouse , 2:Factory, 3:Distribution Center):");
				String facility=in.nextLine();
				if(facility.equals("1")) {
					System.out.println(company.storageInfo("Warehouse"));
				}
				else if(facility.equals("2")) {
					System.out.println(company.storageInfo("Factory"));
				}
				else if(facility.equals("3")) {
					System.out.println(company.storageInfo("Center"));
				}
				System.out.println("Profit= "+ company.companyProfit());
			}
		}
	}
	private void chooseContainerandAmount(String container) {
		System.out.println("Enter the item you want to carry (1:Cacao, 2:Cream, 3:Milk, 4:Yeast):");
		String item=in.nextLine();
		System.out.println("Enter the amount you want to carry");
		double amount=in.nextDouble();
		if(item.equals("1")) {
			company.loadContainer(container, "Cacao",amount);	
		}
		else if(item.equals("2")) {
			company.loadContainer(container, "Cream",amount);	
		}
		else if(item.equals("3")) {
			company.loadContainer(container, "Milk",amount);	
		}
		else if(item.equals("4")) {
			company.loadContainer(container, "Yeast",amount);	
		}	
	}
	private void chooseContainerandProductAmount(String container) {
		System.out.println("Enter the item you want to carry (1:Boxed Milk, 2:Chocolate 3:Yoghurt:");
		String item=in.nextLine();
		System.out.println("Enter the amount you want to carry");
		double amount=in.nextDouble();
		if(item.equals("1")) {
			company.loadContainer(container, "Boxed Milk",amount);	
		}
		else if(item.equals("2")) {
			company.loadContainer(container, "Chocolate",amount);	
		}
		else if(item.equals("3")) {
			company.loadContainer(container, "Yoghurt",amount);	
		}
	}
}
