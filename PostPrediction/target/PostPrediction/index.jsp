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

	<form method="post" action="./predict.do">
		<p>Post Information
		<br>
		Posting Date: <input type="date" name="fiscalYear">
		Company Code: <input type="text" name="companyCode">
		Journal Entry Type: <input type="text" name="journalEntryType">
		Transaction Currency: <input type="text" name="transactionCurrency">
		<br>
		Account: <input type="text" name="accountNumber1">
		Debit: <input type="text" name="debit1">
		Credit: <input type="text" name="credit1">
		<br>
		CostCenter: <input type="text" name="costCenter1">
		ProfitCenter: <input type="text" name="profitCenter1">
		<br>
		Account: <input type="text" name="accountNumber2">
		Debit: <input type="text" name="debit2">
		Credit: <input type="text" name="credit2">
		<br>
		CostCenter: <input type="text" name="costCenter2">
		ProfitCenter: <input type="text" name="profitCenter2">
		<p>
			<input type="submit" value="Post" name="post">
			<input type="reset" value="Reset" name="reset">
			<input type="submit" value="Predict" name="predict">
		</p>
	</form>
</body>
</html>
