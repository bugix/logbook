<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"  xmlns="http://www.w3.org/1999/xhtml" version="1.0">

<xsl:template match="/">
<html>

	
   <head>
  
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
   
   
      <title>Skill</title>
      <style type="text/css">
      .mainPage{
      height:800px;
      width:595px;
      margin-left:auto;
      margin-right:auto;
      
      }
      
      .mainClassification{
      	background-color:rgb(198,236,81);
      	width:100%;
      }
      .classificationTopic{
      margin-bottom:20px;
      width:100%;
      }
      .topic{
      	margin-left:20px;
      	background-color:rgb(255,255,119);
      	 margin-bottom:5px;
      }
      
      .skillTable{
      margin-bottom:30px;
      text-align:center;
      }
      
      .skillTableRow{
      diplay:block;
       border-bottom:1px solid rgb(198,236,81);
       text-align:left;
      }
      .td1{
      min-width="60px";
      max-width="60px";
      }
      .td2{
      min-width="475px";
       max-width="475px";
      }
      .td3{
       min-width="30px";
        max-width="30px";
      }
      .td4{
       min-width="30px";
        max-width="30px";
      }
      
      .padLeft{
      padding-left:4px;
      }
			</style>
   </head>

   <body class="mainPage">
   <div width="100%">
   <xsl:for-each select="mainClassifications/mainClassification">
   
	   	<div class="mainClassification" >
	   		<h2><b><xsl:value-of select="description" /></b></h2>
	   	</div>
	   	
	   	<xsl:for-each select="classificationTopics/classificationTopic">
		   	<div class="classificationTopic">
		   		<b><xsl:value-of select="description" /></b>
		   	</div>
					   	<xsl:for-each select="topics/topic">
					   			<div class="topic" >
					   				<b><xsl:value-of select="description" /></b>
					   			</div>
					   			<table cellspacing="0"  align="center" class="skillTable" cellpadding="0">
					   						<tr  >
					   							 <td class="skillTableRow" align="left"><b>Shortcut</b>
					   							</td>
					   							
					   							<td  class="skillTableRow padLeft" width="70%" align="left"><b>Description</b>
					   							</td>
					   							
					   							<td class="skillTableRow"><b>Skill Level</b>
					   							</td>
					   							<td class="skillTableRow"><b>Skill Acquired Level</b>
					   							</td> 
					   							
					   							<!-- <div class="skillTableRow" width="595px">
									   								<span width="60px" class="td1"><b>Shortcut</b></span>
									   								<span width="475px" class="td2"><b>description</b></span>
									   								<span width="30px" class="td3"><b>Skill Level</b></span>
									   								<span width="30px" class="td4"><b>Skill Acquired Level</b></span>
									   							</div> -->
					   						</tr>
									   			<xsl:for-each select="skills/skill">
									   				
									   						<tr >
									   							 <td class="skillTableRow" align="left">
									   								<xsl:value-of select="shortcut" />
									   							</td >
									   							
									   							<td class="skillTableRow" align="left">
									   								<xsl:value-of select="description" />
									   							</td>
									   							
									   							<td class="skillTableRow">
									   								<xsl:value-of select="skillLevel" />
									   							</td>
									   							<td class="skillTableRow">
									   								<xsl:value-of select="skillLevelAcquired" />
									   							</td> 
									   							<!-- <div class="skillTableRow" width="595px">
									   								<span width="60px" class="td1"><xsl:value-of select="shortcut" /></span>
									   								<span width="475px" class="td2"><xsl:value-of select="description" /></span>
									   								<span width="30px" class="td3"><xsl:value-of select="skillLevel" /></span>
									   								<span width="30px" class="td4"><xsl:value-of select="skillLevelAcquired" /></span>
									   							</div> -->
									   						</tr>
									   				
									   			</xsl:for-each>
					   			</table>
					   	</xsl:for-each>
	   	</xsl:for-each>
    </xsl:for-each>
     </div>
    </body>
</html>
</xsl:template>
</xsl:stylesheet>