<html>
<head>
<meta charset="UTF-8">
	<title>Post Prediction</title>
</head>
<body>
<h2>Post Prediction</h2>
<form method="post" action="./upload.do" enctype="multipart/form-data">
	<input type="file" name="excel" id="excel"> <input type="submit" value="Upload"/>
</form>

	<form method="post" action="post.do">
		<p>Post Information
		<br>
		FiscalYear: <input type="date" name="fiscalYear">
		CompanyCode: <input type="text" name="companyCode">
		<br>
		Account: <input type="text" name="accountNumber">
		<br>
		CostCenter: <input type="text" name="costCenter">
		ProfitCenter: <input type="text" name="profitCenter">
		<p>
			<input type="submit" value="Post" name="post">
			<input type="reset" value="Reset" name="reset">
			<input type="submit" value="Predict" name="predict">
		</p>
	</form>
</body>
</html>
