Compile
========
`javac -cp jsoup.jar:. Crawl.java`

Run (site : ugm.ac.id)
=======================
- tampilkan source

  `java -cp jsoup.jar:. Crawl http://ugm.ac.id source`

- tampilkan metas

  `java -cp jsoup.jar:. Crawl http://ugm.ac.id metas`

- extract links

  `java -cp jsoup.jar:. Crawl http://ugm.ac.id links`

- deteksi robots.txt

  `java -cp jsoup.jar:. Crawl http://ugm.ac.id robots`
