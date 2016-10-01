import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.util.LinkedList;
import java.util.Iterator;
public class ticTac extends temp
	{
     panel3 panel ;
     JFrame frame = new JFrame();
	 LinkedList<Point> al=new LinkedList<Point>(); 
    Timer timer;
     char get;
     int flag[],flag1[][];
int player[],p,status;
	int count;
abstract class panel3 extends JPanel implements ActionListener{ }
class Panel2 extends panel3  
	{
	    
        Panel2() 
			{
			
			}
        @Override
        public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
if(status==0)
				{

				setBackground(Color.WHITE); 
				g.drawRect(10,10,380,380);
				int len=0;
                           for(int i=0;i<3;i++)
                                   {
                                  for(int j=0;j<3;j++)
    					{
					g.drawRect(10+i*40,10+j*40,40,40);
					String s1;
			if(len<10&&len>=0)
                             {      
				if(flag[len]==1)
             				 {s1="X";
						g.drawString(s1,20+i*40,30+j*40);}	
				else if(flag[len]==2)
					{s1="o";
					g.drawString(s1,20+i*40,30+j*40);}
				else
					{s1=""+(len)+"";
					g.drawString(s1,20+i*40,30+j*40);}
				}
			else
			{s1=""+(len)+"";
			g.drawString(s1,20+i*40,30+j*40);}
                                        
			len++;
					}
				}
}
else
{
String s1="player:"+(status)+" win";
			g.drawString(s1,200,200);
timer.stop();
}
                            }
                           	
public void actionPerformed(ActionEvent e) 
			{
			check();
		
			
			repaint();
			}			
    }
 public ticTac()
	{
	status=0;
	panel=new Panel2();
	panel.addKeyListener(this); 
 	timer = new Timer(1,panel);
     	timer.start();  
	flag=new int[9];
	player=new int[9];
	flag1=new int[3][3];
	p=1;
	count=0;
	}
 public void setPanel()
		{ 
         	panel.setFocusable(true);
		panel.setLayout(null);
         	frame.setLayout(null);
         	panel.setBounds(0,0,400,400);
		frame.add(panel);
         	frame.setVisible(true);
         	panel.setVisible(true);
         	frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
void check()
{
	for(int i=0;i<3;i++)
  		{
    		int v=flag1[i][0];
                     for(int j=1;j<3;j++)
    			{
                         
        		  if(v==flag1[i][j]&&v!=0)
                       {   
if(j==2){
                       System.out.println("playerH:"+v);
                   timer.stop();}
                      
 		}
               else
              {
//v=0;
break;
  }
     	}
  }
  /*for(int i=0;i<3;i++)
  {
    int v=flag1[0][i];
   	for(int j=1;j<3;j++)
           {
           if(v==flag1[j][i]&&v!=0)
              {

                status=v;
             System.out.println("playerV:"+v);
             timer.stop();
                }
else
{
v=0;
break;
}
      }
 
}*/
}
    @Override
    public void keyPressed(KeyEvent evt)
		{

          get=evt.getKeyChar();
int i=(int)get-48;

				if(i<10&&i>=0)
                             {  
                               if(flag[i]!=1&&flag[i]!=2)
                             {flag[i]=p; 
if(p==2)
p=1;
else
p=2;
}

            
int len1=0;
  for(int i1=0;i1<3;i1++)
  {
   for(int j=0;j<3;j++)
    {
       flag1[i1][j]=flag[len1]; 
      len1++;
    }
  }                 

}
		}
 	
    public static void main(String [] args)
		{
         ticTac play = new ticTac();
        play.setPanel();
		}
   }