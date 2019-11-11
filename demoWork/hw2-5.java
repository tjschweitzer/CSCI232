class hw2{
    
    public static void main(String[] args) {
        
        
        Character[] chars = {'E','A','S','Y','Q','U','E','S','T','I','O','N'};
        Integer[] hashvals = new Integer[chars.length];
        
        int M=5;
        int x=0;
        for (Character character : chars) {
            hashvals[x++]= (13*(int)character)%M;
        }
        for (Integer integer : hashvals) {
            StdOut.println(integer);
        }
        
    }  
    
}