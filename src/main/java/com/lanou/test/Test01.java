package com.lanou.test;

import java.io.File;

public class Test01{
	
	public static void main(String[] args) {
		
		java.io.File file = new java.io.File("F:\\wapian\\test");
		String dirPath = file.getAbsolutePath();// 目录路径
		if (file.isDirectory()) {
			File[] files = file.listFiles();// 获取此目录下的文件列表
			for (File fileFrom : files) {
				String fromFile = fileFrom.getName();// 文件名
				// 得到图片文件的文件夹 名和文件名
				String[] fname = new String[2];
				String aaa[] = fromFile.split("\\.")[0].split("-");
				fname[0] = String.valueOf(Integer.parseInt(aaa[0].trim()));
				fname[1] = String.valueOf(Integer.parseInt(aaa[1].trim())) + ".png";
				// 如果不存在该文件夹则创建
				File filels = new File(dirPath + "\\" + fname[0]);
				if (!filels.exists()) {
					filels.mkdir();
				}
				File toFile = new File(dirPath + "\\" + fname[0] + "\\" + fname[1]);
				// 开始更名
				fileFrom.renameTo(toFile);
			}
			System.out.println("转换成功");
		}
	}
}
