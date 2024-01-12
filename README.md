
<h2>---------------SELENIUM WEB DRIVER LOCATORS---------------:-</h2>
-->for selenium to understand the html components on the web page ,we will use concept called locators.
--><li>Below are the different locators in the selenium:-</li>
   <ul>1.ID</ul>
   <ul>2.Xpath</ul>
   <ul>3.CSS Selector</ul>
   <ul>4.name</ul>
   <ul>5.Class Name</ul>
   <ul>6.Tag Name</ul>
   <ul>7.Link Text</ul>
   <ul>8.Partial Link Text</ul>
-->if there are no id,classname,name locators,we can use cssSelectors and Xpath for locating the html components on web page.
<h2>---------------HOW TO DO CSSSELECTOR LOCATORS---------------:-</h2>
<li>Three ways to define the cssSelectors as follows.</li>
<li>Class name -> tagname.classname -> Ex:- Button.signInBtn ->Ex:- p.error</li>
<li>Id -> tagname#id  -> Ex:- input#inputUsername</li>
<li>Tagname[attribute=’value’]</li>
<li><input type="text" placeholder="Username” value=" "></li> 
 <li> CssSelectors::-Input [placeholder=’ Username’]</li>      
<h2>---------------HOW TO GENERATE XPATH LOCATORS---------------:-</h2>
<li>Following is the syntax of generating the xpath locators.</li>
<li>//Tagname[@attribute=’value’]</li>
<li>//input[@placeholder=’ Username’]</li>
<li><input type="text" placeholder="Name"></li>
<li>Xpath::- //input[@placeholder=’ Name’]</li>
<li>//Tagname[@attribute=’value’][index],
	//parentTagname/childTagname,
	//button[contains(@class,'submit')].==>Regular expression, 
	//tagname,
	//header/div/button[1]/following-sibling::button[1],
	//header/div/button[1]/parent::div</li>		
<h2>---------------Handling static dropdown using the selenium---------------:-</h2>
<li>static dropdown means in Html code,we should defeintly use SELECT Tag.</li>
<li>First create the class of SELECT Class in selenium and pass the webelement of the dropdown by using locators.</li>
<li>then use the methods like selectByIndex(),selectByVisibleText(),selectByValue() methods for accessing the static dropdown.</li>
<h2>---------------Handling dynamic dropdown using the selenium---------------:-</h2>
<li>By using indexing methods ,we automate the dynamic dropdown.</li>
 <li>Ex:-driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();</li>
<li>By using parent-child relationship,we can find locators and accessing the webelements on the webpage.</li>
 <li>Ex:-//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']</li> 
<li>//div[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']  //a[@value='MAA']</li>
<h2>---------------Handling autosuggestive using the selenium---------------:-</h2>
-->driver.findElement(By.id("autosuggest")).sendKeys("ind");<br>
		Thread.sleep(2000);<br>
		List<WebElement> options=driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));<br>
		for(WebElement element:options) {<br>
			if(element.getText().equalsIgnoreCase("india")) {<br>
				element.click();<br>
				break;<br>
			}<br>
		}<br>
<h2>---------------Handling checkboxes using selenium---------------:-</h2>
-->System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());<br>
-->For clicking the checkboxes<br>
   Ex:-driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();<br>
-->To check weather checkboxes are selected or not -return t or f.<br>
   Ex:-System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());<br>
-->count of the checkboxex in the page<br>
   Ex:-System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());<br>  
<h2>---------------Handling calender current date in ui using selenium---------------:-</h2>
-->driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();  
<h2>---------------Java 8 stream Api---------------:-</h2>
-->If we have arrays,we can convert into list by using Arrays.asList("sravani","santhu","akrtih")<br>
-->Take Arraylist-names and perfome operations on that.<br>
-->names.stream().filter(s->s.startsWith('A')).count();<br>
-->foreach()-->for printing list<br>
-->concat()-->for merging 2 different lists<br>
-->sorted()-->prints sorted list<br>
-->anyMatch()-->returns boolean value according to requriments.<br>
-->collect()-->convert final operations on the list into new list.Ex:-Stream.of("sravani","adam","rama").filter(s->s.endWith('a')).sorted().map(s->s.toUppercase()).collect(Collectors.toList or toSet);<br>
-->distinct()-->select the unique values in the list.<br>
-->limit()-->limit(0)-->gets first value-->limit(1)-->prints the values of 0 and 1st index.<br>
<h2>---------------Intermidate operations and Terminal operations:----------------</h2>
-->There is no life for intermediate op if there is no terminal op.<br>
-->terminal operations will execute only if intermideate operations(filter) returns true.<br>
<h2>---------------We can use streams instead of the arraylist or collections:----------------</h2>
-->Gives the names which end with a and returns the uppercase.<br>
   Ex:-Stream.of("sravani","adam","rama").filter(s->s.endWith('a')).map(s->s.toUppercase());<br>   
-->Perform the sorting:- <br>
   Ex:-Stream.of("sravani","adam","rama").filter(s->s.endWith('a')).sorted().map(s->s.toUppercase()).foreach(s->System.out.println(s)); <br>   
<h2>---------------Handling webelements and tables using java streams:----------------</h2>
-->capture all webelements into list<br>
   Ex:-List<WebElement> Elementslist = driver.findElements(By.xpath("//tr/td[1]"));<br>
-->capture the text of all webelements into new original list<br>
   Ex:-List<String> originallist = Elementslist.stream().map(s -> s.getText()).collect(Collectors.toList());<br>
-->sorting the original list<br>
   Ex:-List<String> sortedlist = originallist.stream().sorted().collect(Collectors.toList());<br>
-->comparing the 2 lists<br>
   Ex:-Assert.assertTrue(originallist.equals(sortedlist));<br>
-->scan the name of the column and if it is rice bring the price of the rice.<br>
   Ex:-List<String> pricelist = Elementslist.stream().filter(s->s.getText().contains("Beans"))<br>
				.map(s->getPriceVeggie(s)).collect(Collectors.toList());<br>
		pricelist.forEach(a->System.out.println(a));<br>
	}<br>
	private static String getPriceVeggie(WebElement s) {<br>
		String text = s.findElement(By.xpath("following-sibling::td[1]")).getText();<br>
		return text;<br>
	}<br>
       
