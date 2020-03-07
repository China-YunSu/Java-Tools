package com.mec.util;

import java.awt.Color;
import java.awt.Font;

public interface IWindow {
	Font topticFont = new Font("楷体",Font.BOLD,36);
	int topticSize = topticFont.getSize();
	
	Font defaultFont  = new Font("宋体",Font.PLAIN,20);
	int defaultSize = defaultFont.getSize();
	
	Font maxFont  = new Font("宋体",Font.PLAIN,23);
	int maxFontsize = maxFont.getSize();
	
	Font minFont  = new Font("宋体",Font.PLAIN,16);
	int minFontsize = minFont.getSize();
	
	Font boldFont =  new Font("宋体", Font.BOLD, 20);
	int boldFontsize = boldFont.getSize();
	
	Color topticColor = Color.BLUE;
	int textFieldLength = 25;
	
	default void initView() {
		init();
		dealEvent();
		reinit();
	}

	void dealEvent();
	void reinit();
	void init();
	void showView();
	void exitView();
}
