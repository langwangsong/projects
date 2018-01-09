package cn.itcast.demo4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestCodeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取画布对象
		BufferedImage image = new BufferedImage(300,300,BufferedImage.TYPE_INT_RGB);
		//获取画笔对象
		Graphics g = image.getGraphics();
		//设置画笔的颜色
		g.setColor(Color.RED);
		//画矩形
		g.drawRect(50, 50, 100, 100);
		//画字符串
		g.setColor(Color.BLUE);
		String str = "哈哈";
		g.drawString(str, 60, 60);
		//释放资源
		g.dispose();
		//先把内存中的画布输出到客户端上
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
