# OKEX Funding Rate Calculator
用于计算OKEX永续合约资金费率

## 使用方法
1. 修改application-sample.yml配置文件并将其重命名为application.yml
2. 访问localhost:8079/list90 查看所有合约近一个月的资金费用

## 返回示例, 从大到小排序
```
[
    {
        "contractId": "BSV-USDT-SWAP",
        "sum": 0.06969412,
        "sumInPercent": "6.97%",
        "period": 90
    },
    {
        "contractId": "XRP-USDT-SWAP",
        "sum": 0.06183993,
        "sumInPercent": "6.18%",
        "period": 90
    },
    {
        "contractId": "BTC-USDT-SWAP",
        "sum": 0.05706706,
        "sumInPercent": "5.71%",
        "period": 90
    },
    {
        "contractId": "EOS-USDT-SWAP",
        "sum": 0.05581700,
        "sumInPercent": "5.58%",
        "period": 90
    },
    {
        "contractId": "BSV-USD-SWAP",
        "sum": 0.05151042,
        "sumInPercent": "5.15%",
        "period": 90
    },
    {
        "contractId": "EOS-USD-SWAP",
        "sum": 0.05054686,
        "sumInPercent": "5.05%",
        "period": 90
    },
    {
        "contractId": "BCH-USDT-SWAP",
        "sum": 0.04870966,
        "sumInPercent": "4.87%",
        "period": 90
    },
    {
        "contractId": "TRX-USDT-SWAP",
        "sum": 0.04736886,
        "sumInPercent": "4.74%",
        "period": 90
    },
    {
        "contractId": "BCH-USD-SWAP",
        "sum": 0.04621930,
        "sumInPercent": "4.62%",
        "period": 90
    },
    {
        "contractId": "LTC-USD-SWAP",
        "sum": 0.04487529,
        "sumInPercent": "4.49%",
        "period": 90
    },
    {
        "contractId": "ETH-USDT-SWAP",
        "sum": 0.04379022,
        "sumInPercent": "4.38%",
        "period": 90
    },
    {
        "contractId": "XRP-USD-SWAP",
        "sum": 0.04326054,
        "sumInPercent": "4.33%",
        "period": 90
    },
    {
        "contractId": "TRX-USD-SWAP",
        "sum": 0.04161140,
        "sumInPercent": "4.16%",
        "period": 90
    },
    {
        "contractId": "LTC-USDT-SWAP",
        "sum": 0.04095906,
        "sumInPercent": "4.10%",
        "period": 90
    },
    {
        "contractId": "BTC-USD-SWAP",
        "sum": 0.03936031,
        "sumInPercent": "3.94%",
        "period": 90
    },
    {
        "contractId": "ETH-USD-SWAP",
        "sum": 0.03813659,
        "sumInPercent": "3.81%",
        "period": 90
    },
    {
        "contractId": "ETC-USD-SWAP",
        "sum": 0.02602004,
        "sumInPercent": "2.60%",
        "period": 90
    },
    {
        "contractId": "ETC-USDT-SWAP",
        "sum": 0.01442711,
        "sumInPercent": "1.44%",
        "period": 90
    }
]
```

