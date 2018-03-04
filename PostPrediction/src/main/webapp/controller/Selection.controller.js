sap.ui.define([ "sap/ui/core/mvc/Controller", "sap/m/MessageToast",
		"sap/ui/model/json/JSONModel", "sap/ui/model/resource/ResourceModel" ],
		function(Controller, MessageToast, JSONModel, ResourceModel) {
			"use strict";
			return Controller.extend("sap.predictpost.controller.Selection", {
				onInit : function() {
					// set data model on view
					var oData = {
						InterCompAdjust : false,
						Payroll : false,
						Accrual : false,
						FinancialAdjust : false
					};
					var oModel = new JSONModel(oData);
					this.getView().setModel(oModel, "businesstype");

					// set i18n model on view
					var i18nModel = new ResourceModel({
						bundleName : "sap.predictpost.i18n.i18n"
					});
					this.getView().setModel(i18nModel, "i18n");
				},
				onShowHello : function() {
					// read msg from i18n model
					var oBundle = this.getView().getModel("i18n")
							.getResourceBundle();
					var sRecipient = this.getView().getModel().getProperty(
							"/recipient/name");
					var sMsg = oBundle.getText("helloMsg", [ sRecipient ]);
					// show message
					MessageToast.show(sMsg);
				},
				onPredict : function() {
					// var model = this.getView().getModel();
					// model.read("/test", {success:
					// function(res){console.log(res)}});
					// this.doAjex("/sap/predict.do").done(this.updateModelData)

					var predictionModel = new JSONModel({
						bundleName : "sap.predictpost.Prediction"
					});
					predictionModel.loadData("Prediction.json");
					this.getView().setModel(predictionModel, "prediction");

					var test1 = this.getView().getModel("businesstype")
							.getProperty("/InterCompAdjust");
					MessageToast.show(test1);
				},
				updateModelData : function(modelData) {
					console.debug("Ajax response: ", modelData);
					var model = this.getView().getModel();
					if (model == null) {
						// create new JSON model
						this.getView().setModel(
								new sap.ui.model.json.JSONModel(modelData));
					} else {
						// update existing view model
						model.setData(modelData);
						model.refresh();
					}
				},
				onFilterPredictionList : function(oEvent) {

					// build filter array
					var aFilter = [];
					var sQuery = oEvent.getParameter("query");
					if (sQuery) {
						aFilter.push(new Filter("Business",
								FilterOperator.Contains, sQuery));
					}

					// filter binding
					var oList = this.byId("predictionList");
					var oBinding = oList.getBinding("items");
					oBinding.filter(aFilter);
				}
			});
		});