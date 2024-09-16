package fr.avainfo.m2igrenoble

import java.net.HttpURLConnection
import java.net.URL

fun sendGet() {
	val url = URL("https://jsonplaceholder.typicode.com/todos/1")

	with(url.openConnection() as HttpURLConnection) {
		requestMethod = "GET"

		println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")

		var i = 0;
		inputStream.bufferedReader().use {
			it.lines().forEach { line ->
				println("[${i++}]: $line")
			}
		}
	}
}

fun main() {
	sendGet()
}
