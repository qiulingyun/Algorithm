<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="./css/PredictivePosting.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="./js/PredictivePosting.js"></script>
<title>Predictive Posting Generation</title>
</head>
<body>
<h2 id="title" class="title">Predictive Posting for</h2>
<form method="post" action="./massPredict.do" >
	<div class="title"><input type="checkbox" name="intercompanyadjust" id="intercompanyadjust"> InterCompany Adjustment</div>
	<div class="title"><input type="checkbox" name="payroll" id="payroll"> Payroll </div>
	<div class="title"><input type="checkbox" name="accrual" id="accrual"> Accrual </div>
	<div class="title"><input type="checkbox" name="financialadjust" id="financialadjust"> Financial Adjustment </div>
	<div class="title"><input type="checkbox" name="interestpost" id="interestpost"> Interest Postings </div>
	<br>
	<table id="choice">
	<tr>
		<th  class="choice_td">Today</th>
		<th  class="choice_td">This Week</th>
		<th  class="choice_td">This Month</th>
		<th  class="choice_td">This Quarter</th>
		<th  class="choice_td">This Year</th>
		<td  id="generate_btn_td"><input type="submit" id="massPredict" value="Generate"/></td>
	</tr>
	</table>
	
	
</form>
</body>
</html>