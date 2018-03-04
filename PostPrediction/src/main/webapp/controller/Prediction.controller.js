sap.ui.define([
   "sap/ui/core/mvc/Controller", 
   "sap/m/MessageToast",
   "sap/ui/model/json/JSONModel",
   "sap/ui/model/resource/ResourceModel",
   "sap/ui/model/Filter",
   "sap/ui/model/FilterOperator"
], function (Controller, MessageToast, JSONModel, ResourceModel, Filter, FilterOperator) {
   "use strict";
   return Controller.extend("sap.predictpost.controller.Prediction", {
	   onInit : function () {
			var oViewModel = new JSONModel({
				currency: "EUR"
			});
			this.getView().setModel(oViewModel, "view");
		},
		onFilterPredictionList : function (oEvent) {

			// build filter array
			var aFilter = [];
			var sQuery = oEvent.getParameter("query");
			if (sQuery) {
				aFilter.push(new Filter("Business", FilterOperator.Contains, sQuery));
			}

			// filter binding
			var oList = this.byId("predictionList");
			var oBinding = oList.getBinding("items");
			oBinding.filter(aFilter);
		}
   });
});