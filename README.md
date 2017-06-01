# selenium-pageobject-framework-withGenerics
page object with generics and some other good practices


<h1 style="color: #5e9ca0;">page object with Generics</h1>
<h2 style="color: #2e6c80;">How to setup and run:</h2>
<p>This framework uses&nbsp;Java 1.8, selenium web driver 3.X, maven, apache POI, testNG and&nbsp;geckodriverv0.14.0 for firefox.</p>
<p>If the current version of geckodriver does not support your firefox, please replace the provided driver with your executable version of geckodriver in the following path:</p>
<p>geekoDriverPath = src\\resources\\geckodriverv0.14.0.exe</p>
<p>by opening configuration file located at&nbsp;/src/com/binupjewelry/config/GlobalConfig.properties</p>
<p>If needed, update &lt;dependency&gt; in pom.xml</p>
<p><span style="background-color: #2b2301; color: #fff; display: inline-block; padding: 3px 10px; font-weight: bold; border-radius: 5px;">Run</span>&nbsp;sample test case "<span style="color: #ff0000;"><strong>SearchAndBuyRingTest.java</strong></span>" as TestNG test.</p>
<h2 style="color: #2e6c80;">Some best practices followed are:</h2>
<li >Avoiding assertions in the page object</li>
<li >Returning page object while navigating for the next page</li>
<li>Using Generics to to create page model objects by class name rather than having to “new them up”. This practice keeps initialization code in one place so that it easier to extend/modify.</li>
<li >Returning page object while navigating for the next page</li>
<li >Ensuring that a page or element is ready before interacting with it</li>
<li ><b> "If you have WebDriver APIs in your test methods, You're Doing It Wrong"</b></li>

<h4>Demo Site:&nbsp;https://binup-jewelry.offersupermarket.com/</h4>

<p><img src="https://cloud.githubusercontent.com/assets/10625539/26386581/67f4a074-3ffc-11e7-9dc4-37c712cfb6aa.png" alt="structure" width="1090" height="574" /></p>
