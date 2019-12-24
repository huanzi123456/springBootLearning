POST /dzxiaodian/customerorder/_search
{
    "query": {
      "bool": {
          "must": [
             {"range": {
              "CreateTime": {
                 "gte": "2019-01-01",
                 "lt": "2019-12-25"
              }
           }}, {
            "terms": {
            "PurOrderStatue": [
              "5",
              "2",
              "3",
              "4"
            ]
          }
        }
          ]
      }

    },
         
   "size": 0,
"aggregations": {
      "all_tags": {
      "terms": {
        "field": "ShopId",
        "size": 10000
      },
      "aggregations": {
        "orderPaySum": {
          "sum": {
            "field": "TotalAmount"
          }
        }
      }
    }
  }
}