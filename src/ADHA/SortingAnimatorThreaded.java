package ADHA;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SortingAnimatorThreaded extends JFrame implements ActionListener  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*holds numbers to be sorted*/
	int numbers[];
	
	/**number of numbers to be sorted*/
	int numColumns = 50;
	
	ButtonGroup[] buttonGroups;
	int numButtonGroups = 4;
	
	JButton[] buttons;
	int numButtons = 3;
	
	JRadioButton[][] radioButtons;
	int numRadioButtons = 16;
	
	JLabel[] labels;
	int numLabels = 3;
	
	JPanel[] panels;
	int numPanels = 5;
	
	
	MyJPanel drawingArea;
	
	int delay=10;
	
	int drawingAreaWidth;
	
	int drawingAreaHeight;
	
	int heightDivisor = 150;
	
	int heightDifference = 45;
	//if true, when paint is called numbers will be sorted using the selected parameters
	boolean sort = false;
	
	boolean rectangles = false;
	
	boolean paused = false;
	
	boolean stop = false;
	
	boolean stepping = false;
	public static void main(String[] args) 
	{
		SortingAnimatorThreaded sorter = new SortingAnimatorThreaded();
	}
	
	public SortingAnimatorThreaded()
	{
		super();
		
		this.setTitle("Sorting Animator By ADH ");
		this.setVisible(true);
		this.setBackground(Color.white);
		
		
		setName("Sorting Animator ");
		setSize(800, 500);
		
		createButtons();
		
		createLabels();
		
		createPanels();
		
		createArray();
		
		shuffle();
		
	}

	/**
	 *  instantiates all the button objects
	 */
	private void createButtons()
	{
		buttonGroups = new ButtonGroup[numButtonGroups];
		radioButtons = new JRadioButton[numButtonGroups][];
		
		radioButtons[0] = new JRadioButton[4];
		             
		radioButtons[0][0] = new JRadioButton("15");
		radioButtons[0][1] = new JRadioButton("20");
		radioButtons[0][1].setSelected(true);
		radioButtons[0][2] = new JRadioButton("25");
		radioButtons[0][3] = new JRadioButton("30");
		
		buttonGroups[0] = new ButtonGroup();
		for(int i=0;i<4;i++)
		{
			buttonGroups[0].add(radioButtons[0][i]);
		}

		radioButtons[3] = new JRadioButton[1];
        
		/*radioButtons[3][0] = new JRadioButton("Points");
		radioButtons[3][0].setSelected(false);*/
		radioButtons[3][0] = new JRadioButton("Bars");
		radioButtons[3][0].setSelected(true);
		
		buttonGroups[3] = new ButtonGroup();
		for(int i=0;i<1;i++)
		{
			buttonGroups[3].add(radioButtons[3][i]);
		}

		radioButtons[1] = new JRadioButton[4];
		radioButtons[1][0] = new JRadioButton("Bubble");
		radioButtons[1][0].setSelected(true);
		radioButtons[1][1] = new JRadioButton("Selection");
		radioButtons[1][2] = new JRadioButton("Insertion");
		radioButtons[1][3] = new JRadioButton("Merge");

		buttonGroups[1] = new ButtonGroup();
		
		for(int i=0;i<4;i++)
		{
			buttonGroups[1].add(radioButtons[1][i]);
		}

		radioButtons[2] = new JRadioButton[3];
        
		radioButtons[2][0] = new JRadioButton("Fast");
		radioButtons[2][1] = new JRadioButton("Medium");
		radioButtons[2][1].setSelected(true);
		radioButtons[2][2] = new JRadioButton("Slow");
		
		buttonGroups[2] = new ButtonGroup();
		
		for(int i=0;i<3;i++)
		{
			buttonGroups[2].add(radioButtons[2][i]);
		}

		buttons = new JButton[numButtons];
		buttons[0] = new JButton("Sort!");
		buttons[1] = new JButton("Shuffle!");
		buttons[2] = new JButton("Step");
		buttons[2].setEnabled(false);
		
		for(int i=0;i<buttons.length;i++)
		{
			buttons[i].addActionListener(this);
		}
	}

	/**
	 * instantiates all of the panels and adds the buttons/labels to them, then
	 * adds the panels to the applet
	 */
	private void createLabels()
	{
		labels = new JLabel[numLabels];
		
		for(int i=0;i<numLabels;i++)
		{
			labels[i] = new JLabel();
		}
		
		labels[0].setText("----Number of Columns----");
		labels[1].setText("----------Algorithm----------");
		labels[2].setText("-------------Speed-------------");
	
		
	
	}

	private void createPanels()
	{
		panels = new JPanel[numPanels];
		
		for(int i=0;i<numPanels;i++)
			panels[i] = new JPanel();
		

		panels[1].setLayout(new GridLayout(buttonGroups[0].getButtonCount()+2, 1));
		panels[2].setLayout(new GridLayout(buttonGroups[1].getButtonCount()+1, 1));
		panels[3].setLayout(new GridLayout(buttonGroups[2].getButtonCount()+1, 1));
		panels[4].setLayout(new GridLayout(buttonGroups[3].getButtonCount()+1, 1));
		
		for(int i=1;i<panels.length-1;i++)
		{
				panels[i].add(labels[i-1]);
				
				for(int j=0;j<radioButtons[i-1].length;j++)
					panels[i].add(radioButtons[i-1][j]);
		}
		//add shuffle button
		panels[1].add(buttons[1]);
		
	
		
		for(int j=0;j<radioButtons[3].length;j++)
			panels[4].add(radioButtons[3][j]);

		
		//add everything to right panel
		panels[0].setLayout(new GridLayout(numButtonGroups,1));

		panels[0].add(panels[4]);
				
		for(int i=1;i<numPanels-1;i++)
		{
			panels[0].add(panels[i]);
		}
				
		//add everything to applet
		setLayout(new BorderLayout());
		
		JLabel title = new JLabel("Sorting Animator");
		JPanel titlepanel = new JPanel();
		titlepanel.add(title);
		title.setFont(new Font("pats font", Font.PLAIN, 20));
		add(titlepanel, BorderLayout.NORTH);
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1,2));
		bottomPanel.add(buttons[0]);
		bottomPanel.add(buttons[2]);
		add(bottomPanel, BorderLayout.SOUTH);
		add(panels[0], BorderLayout.EAST);
		
		drawingArea = new MyJPanel();
		
		add(drawingArea, BorderLayout.CENTER);
	}

	
   /**
    * creates the array of numbers to be sorted and shuffles it
    */
	private void createArray()
	{
		numbers = new int[numColumns];
		 
		for (int i = 0; i<numColumns; i++)
	    {
			numbers[i] = (i+1);     
	    }
	}


	public void paint( Graphics g ) 
	{
		if(drawingArea!=null)
			drawingArea.repaint();
		
		super.paint(g);

	}
	
	
	/**
	 * shuffles numbers so it is unsorted
	 */
	private void shuffle()
	{
		Random rand = new Random();
	     
		for (int i = 0; i<numColumns; i++)
			swap(i,rand.nextInt(numColumns-1));	
	}


	private void swap(int j, int k)
	{
		//swap values in array
		int temp = numbers[j];
		numbers[j] = numbers[k];
		numbers[k] = temp;
	}

	private void displayBars(Graphics g)
	{
		//g.clearRect(20,20,drawingAreaWidth,drawingAreaHeight);
		//draws border
		//g.drawRect(19, 19, drawingAreaWidth+2, drawingAreaHeight+2);
		
		
			for(int j=0;j<numColumns;j++)
				drawPoint(j,numbers[j], g);
	}

	private void drawPoint(int index, int height, Graphics g)
	{
		clearColumn(index,g);
		
    	g.setColor(Color.blue);
    	
    	int rectHeight = (getHeight()-heightDifference*2)/numColumns*height;
    	
		if(rectangles)
			g.fillRect( (index*(drawingAreaWidth-50)/numColumns)+50, 
					getHeight()-rectHeight-heightDifference, 
					(drawingAreaWidth-50)/numColumns, 
					rectHeight);
				}

				private void clearColumn(int index, Graphics g)
				{
					g.setColor(Color.white);
					g.fillRect((index*(drawingAreaWidth-50)/numColumns)+50, heightDifference, 
							(drawingAreaWidth-50)/numColumns, 
							(getHeight())-heightDifference*2+5);
				}
				private boolean compareExchange(int j, int k)
				{
					if(numbers[j]<numbers[k])
					{
						swap(j,k);
						drawingArea.repaint();
						return true;
					}		
					else
						return false;
				}
				private void getDelay()
				{
					String speed = "";
					for(int i = 0; i<radioButtons[2].length;i++)		
						if(radioButtons[2][i].isSelected())
							speed = radioButtons[2][i].getText();
					
					if(speed.equals("Fast"))
						delay = 100;
					else if(speed.equals("Medium"))
						delay = 250;
					else 
						delay = 500;
				}
				private void delay()
				{	
					long oldTime = System.currentTimeMillis();
					while(System.currentTimeMillis()-oldTime<delay)
					{}	
				}
				public void actionPerformed(ActionEvent arg0) 
	{
		if (arg0.getActionCommand().equals("Sort!"))
		{
			buttons[0].setText("Pause");
			buttons[1].setText("Stop");
	
			getDelay();
			sort=true;
			stop = false;
			stepping = false;
			paused=false;
			drawingArea.repaint();
		}
		else if (arg0.getActionCommand().equals("Step"))
		{
			stepping = true;
			paused = false;
			buttons[0].setText("Continue");
		}
		else if (arg0.getActionCommand().equals("Shuffle!"))
		{
			stop = false;
			
			buttons[1].setText("Shuffle!");
			buttons[0].setText("Sort!");
			
			for(int i = 0; i<radioButtons[0].length;i++)
			{
				if(radioButtons[0][i].isSelected())
					numColumns = Integer.parseInt(radioButtons[0][i].getText());
			}
			rectangles=radioButtons[3][0].isSelected();
			
			createArray();
			shuffle();
			drawingArea.repaint();
		}
		else if (arg0.getActionCommand().equals("Pause"))
		{
			buttons[0].setText("Continue");
			buttons[2].setEnabled(true);
			paused = true;
			
		}
		else if (arg0.getActionCommand().equals("Continue"))
		{
			buttons[0].setText("Pause");
			buttons[1].setText("Stop");
			buttons[2].setEnabled(false);
			stop = false;
			stepping = false;
			paused = false;
		}
		else if (arg0.getActionCommand().equals("Stop"))
		{
			buttons[1].setText("Shuffle!");
			buttons[2].setEnabled(false);
			paused = false;
			stop = true;
			stepping=false;
			buttons[0].setText("Sort!");
			drawingArea.repaint();
		}

	}
	
	class insertionSortThread extends Thread implements Runnable
	{
		public void run() {
			for(int i=0;i<numColumns;i++)
			{
				for(int j=i-1;j>-1;j--)
				{
					while(paused)
						try{sleep(1);}catch(Exception e){};
						
					if(stop)
						return;
					
					delay();
					if(!compareExchange(j+1, j))
						break;
					
					if(stepping)
						paused=true;
					
				}	
			}	
			buttons[1].setText("Shuffle!");
			buttons[0].setText("Sort!");
			buttons[2].setEnabled(false);
		}
	}


	class bubbleSortThread extends Thread implements Runnable
	{
		public void run() {
			for(int i=0;i<numColumns;i++)
				for(int j=numColumns-1;j>i;j--)
				{
					while(paused)
						try{sleep(1);}catch(Exception e){};
						
					if(stop)
						return;
					
					delay();
					compareExchange(j,j-1);
					if(stepping)
						paused=true;
					
				}
			buttons[1].setText("Shuffle!");
			buttons[0].setText("Sort!");
			buttons[2].setEnabled(false);
		}
	}


	class selectionSortThread extends Thread implements Runnable
	{
		public void run() {
			for(int i=0;i<numColumns-1;i++)
			{
				int min = i;
				for(int j=i+1;j<numColumns;j++)
				{
					while(paused)
						try{sleep(1);}catch(Exception e){};
						
					if(stop)
						return;
						
					delay();
					
					if(numbers[j]<numbers[min])
						min=j;
					
				}
				compareExchange(min, i);
				if(stepping)
					paused=true;
				
			}
			buttons[1].setText("Shuffle!");
			buttons[0].setText("Sort!");
			buttons[2].setEnabled(false);
		}
	}


	class mergeSortThread extends Thread implements Runnable
	{
		public void run() {
			
			numbers = mergeSort(numbers, 0);
			drawingArea.repaint();
			buttons[1].setText("Shuffle!");
			buttons[0].setText("Sort!");
			buttons[2].setEnabled(false);
		}
		
		
		private int[] mergeSort(int[] a, int startIndexInNumbers)
		{
			while(paused)
				try{sleep(1);}catch(Exception e){};
				
			if(stop)
				return a;
				
			if(a.length<2)
				return a;
			else
			{
				int middle = a.length / 2;
				int left[] = new int[middle];
				int right[] = new int[a.length-middle];
				
			    for (int x=0; x<middle; x++)
			    	left[x]=a[x];

			    for (int x=middle;x<a.length;x++)
			    	right[x-middle]=a[x];
			    
			    left = mergeSort(left, startIndexInNumbers);
			    right = mergeSort(right, startIndexInNumbers+middle);
			    
			  
			    for (int x=0; x<middle; x++)
			    	numbers[startIndexInNumbers+x]=left[x];
			    
			    for (int x=middle;x<a.length;x++)
			    	numbers[startIndexInNumbers + x] = right[x-middle];
			    
			    a = merge(left, right);
			    	
			    for (int x=0; x<a.length; x++)
			    {
		        	delay();
			    }
			    drawingArea.repaint();
			    if(stepping)
					paused=true;
			    return a;
			}
		}
		
		
		/**
		 * merges two subarrays into one sorted array
		 * @param left left side
		 * @param right right side
		 * @return merged sorted array
		 */
		private int[] merge(int[] left, int[] right)
		{
			int result[] = new int[left.length+right.length];
			int leftIndex = 0;
			int rightIndex = 0;
			int index = 0;
		    while (leftIndex < left.length && rightIndex < right.length)
		    {
		    	while(paused)
					try{sleep(1);}catch(Exception e){};
					
		        if (left[leftIndex] < right[rightIndex])
		        {
		        	result[index]=left[leftIndex];
		        	leftIndex++;
		        	index++;
		        }
		        else
		        {
		        	result[index]=right[rightIndex];
		        	rightIndex++;
		        	index++;
		        }
		    }
		    while (leftIndex<left.length) 
		    {
		    	while(paused)
					try{sleep(1);}catch(Exception e){};
		    	result[index]=left[leftIndex];
		    	leftIndex++;
		    	index++;
		    }
		    while (rightIndex<right.length) 
		    {
		    	while(paused)
					try{sleep(1);}catch(Exception e){};
		    	result[index]=right[rightIndex];
		    	rightIndex++;
		    	index++;
		    }
			return result;
		}
	}



	class MyJPanel extends JPanel
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyJPanel()
		{
			super();
		}
		
		/**
		 * override paint method
		 */
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			
			g.setColor(Color.white);
			
			g.clearRect(5,5,this.getWidth()-10, this.getHeight()-10);

			g.setColor(Color.blue);
			//draws border
			g.drawRect(5, 5, this.getWidth()-10, this.getHeight()-10);
			
			if(numbers!=null)
			{
				int barWidth = (getWidth()-20)/numColumns;
				
				for(int j=0;j<numColumns;j++)
				{
					g.setColor(Color.white);
					g.fillRect(j*barWidth + 15, 10, 
							barWidth, 
							getHeight()-20);
					
			    	g.setColor(Color.blue);
			    	
			    	int rectHeight = (int)((double)getHeight()-20)/numColumns*numbers[j];
			    	
					if(rectangles)
						g.fillRect( j*barWidth + 15, 
								getHeight()-rectHeight-20, 
								barWidth, 
								rectHeight);	


				}
			}


			if(sort)
			{
				String whichSort = "";
				for(int i = 0; i<radioButtons[1].length;i++)		
					if(radioButtons[1][i].isSelected())
						whichSort = radioButtons[1][i].getText();
				
				//if selection sort has been chosen call it
				if(whichSort.equals("Selection"))
				{
					Thread t = new selectionSortThread();
					t.start();
					//selectionSort(g);
				}
				//if bubble sort has been chosen call it
				else if(whichSort.equals("Bubble"))
				{
					Thread t = new bubbleSortThread();
					t.start();
					//bubbleSort(g);
				}
				//if merge sort has been chose call it
				else if(whichSort.equals("Merge"))
				{
					Thread t = new mergeSortThread();
					t.start();
					//numbers = mergeSort(numbers, 0, g);
				}

				else if(whichSort.equals("Insertion"))
				{
					Thread t = new insertionSortThread();
					t.start();
				}

				
				sort = false;
			}	
		}
	}
	
}

			
	
							
				

	
	
		
	
	
