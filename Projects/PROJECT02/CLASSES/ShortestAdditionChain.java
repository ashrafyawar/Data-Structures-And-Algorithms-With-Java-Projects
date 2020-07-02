public class ShortestAdditionChain{
	
	public static void main(String arg[]){

		int array[] = {1, 2, 3, 4, 7, 8, 16, 32, 39, 71};
		int current = array[0],counter;
		boolean flag;
	
		for (int i = 1;i < array.length ;i++){
			
			if(current*2 == array[i]){
				System.out.println(current +","+current);
				current = array[i];
			}
			else{

				flag = true;counter = 0;
				while(flag == true && counter < i){
					for(int j = counter;j < i ;j++){
						if(array[counter] + array[j+1] == array[i]){
							System.out.println(array[counter]+","+array[j+1]);
							flag = false;
						}
					}
					counter++;
				}
				current = array[i];
			}
			System.out.println(current);	
		}
	}
}