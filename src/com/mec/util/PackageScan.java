package com.mec.util;

import java.io.File;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public abstract class PackageScan {

	public PackageScan() {
	}

	protected abstract void dealClass(Class<?> klass);

	private void dealPackage(File curFile, String packageName) throws ClassNotFoundException {
		File[] files = curFile.listFiles();
		for (File file : files) {
			String fileName = file.getName();
			if (file.isFile() && fileName.endsWith(".class")) {
				String className = packageName + "." + fileName.replace(".class", "");
				Class<?> klass = Class.forName(className);
				dealClass(klass);
			} else {
				dealPackage(file, packageName + "." + file.getName());
			}
		}
	}

	public void dealJarFile(String path, URL url) throws Exception {
		JarURLConnection jarUrlconnection = (JarURLConnection) url.openConnection();
		JarFile jarFileContain = jarUrlconnection.getJarFile();
		Enumeration<JarEntry> filesEntries = jarFileContain.entries();

		while (filesEntries.hasMoreElements()) {
			JarEntry jarEntry = filesEntries.nextElement();
			String fileName = jarEntry.getName();
			if (fileName.endsWith(".class") && fileName.startsWith(path)) {
				String className = fileName.substring(0, fileName.indexOf(".class")).replace('/', '.');
				Class<?> klass = Class.forName(className);
				dealClass(klass);
			}
		}

	}

	public void scanPackage(String packageName) throws Exception {
		String path = packageName.replace('.', '/');
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

		Enumeration<URL> urls = classLoader.getResources(path);
		while (urls.hasMoreElements()) {
			URL url = urls.nextElement();
			String protocol = url.getProtocol();
			if (protocol.equalsIgnoreCase("file")) {
				File file = new File(url.toURI());
				dealPackage(file, packageName);
			} else if (protocol.equalsIgnoreCase("jar")) {
				dealJarFile(path, url);
			}

		}
	}
}
