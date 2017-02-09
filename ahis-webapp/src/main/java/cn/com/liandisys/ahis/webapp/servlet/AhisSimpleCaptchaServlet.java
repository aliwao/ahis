package cn.com.liandisys.ahis.webapp.servlet;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.liandisys.ahis.webapp.captcha.AhisCaptchaProducer;
import nl.captcha.Captcha;
import nl.captcha.backgrounds.GradiatedBackgroundProducer;
import nl.captcha.noise.CurvedLineNoiseProducer;
import nl.captcha.noise.NoiseProducer;
import nl.captcha.servlet.CaptchaServletUtil;
import nl.captcha.servlet.SimpleCaptchaServlet;
import nl.captcha.text.renderer.ColoredEdgesWordRenderer;

@WebServlet(urlPatterns = "/images/captcha", description = "This is SimpleCaptchaServlet for Ahis.")
public class AhisSimpleCaptchaServlet extends SimpleCaptchaServlet {

	private static final long serialVersionUID = -7006616489509014589L;
	public static final String ATTR_NAME = "ATTR#SIMPLE_CAPTCHA";
	private static final Color NOISE_COLOR = Color.BLACK;

	// 背景色
	private static final Color BACKGROUND_COLOR = new Color(100, 200, 200);
	private static final char[] CHARS = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'k', 'm', 'n', 'p', 'r',
			'w', 'x', 'y', '2', '3', '4', '5', '6', '7', '8' };
	private static final char[] CALCULATE_OPERATION_CHARS = new char[] { '+', '-', '×', '÷' };
	private static final Color WORD_COLOR = Color.BLACK;
	private static final java.util.List<Color> WORD_COLORS;
	private static final java.util.List<Font> WORD_FONTS;
	static {
		WORD_COLORS = new ArrayList<Color>(2);
		WORD_COLORS.add(WORD_COLOR);
		WORD_FONTS = new ArrayList<Font>(3);
		WORD_FONTS.add(new Font("Geneva", 2, 48));
		WORD_FONTS.add(new Font("Courier", 1, 48));
		WORD_FONTS.add(new Font("Arial", 1, 48));
	}

	private static int _width = 200;
	private static int _height = 50;
	private static int _text_length = 4;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		if (getInitParameter("captcha-height") != null) {
			_height = Integer.valueOf(getInitParameter("captcha-height")).intValue();
		}
		if (getInitParameter("captcha-width") != null) {
			_width = Integer.valueOf(getInitParameter("captcha-width")).intValue();
		}
		if (getInitParameter("captcha-text-length") != null) {
			_text_length = Integer.valueOf(getInitParameter("captcha-text-length")).intValue();
		}
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Captcha captcha = new Captcha.Builder(_width, _height)
				.addText(new AhisCaptchaProducer(),
						new ColoredEdgesWordRenderer(WORD_COLORS, WORD_FONTS, 0))
				.addBackground(new GradiatedBackgroundProducer(BACKGROUND_COLOR, Color.WHITE))
				.addNoise((NoiseProducer) (new CurvedLineNoiseProducer(NOISE_COLOR, 3))).addBorder().gimp().build();
		
		CaptchaServletUtil.writeImage(resp, captcha.getImage());
		req.getSession().setAttribute(ATTR_NAME, captcha);
		System.out.println(captcha.getAnswer());
		System.out.println(captcha.getTimeStamp());
	}
}
