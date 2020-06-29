<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>

<html>
<head>
    <title>Currency Data</title>
    <link href="static/css/myView.css"
        rel="stylesheet">
</head>
<h1><span class="blue"></span>Cryptocurrency Data<span class="blue"></span></h1>

<table class="container">
	<jsp:useBean id = "currency" class = "database.DBInstanceWrapper"> 
	</jsp:useBean>
	<thead>
		<tr>
		
			<th><h1>Currency Code</h1></th>
			<th><h1>RSI</h1></th>
			<th><h1>EMA</h1></th>
			<th><h1>Deviation</h1></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td onclick="location.href='https://coincap.io/assets/algorand'">
			<a href="https://coincap.io/assets/algorand">ALGO</a></td>
			<td><%out.println(currency.getRSI()[0]);%></td>
			<td><%out.println(currency.getEMA()[0]);%></td>
			<td><%out.println(currency.getDeviation()[0]);%></td>
		</tr>
		<tr>
			<td onclick="location.href='https://coincap.io/assets/cosmos'">
			<a href="https://coincap.io/assets/cosmos">ATOM</a></td>
			<td><%out.println(currency.getRSI()[1]);%></td>
			<td><%out.println(currency.getEMA()[1]);%></td>
			<td><%out.println(currency.getDeviation()[1]);%></td>
		</tr>
		<tr>
			<td onclick="location.href='https://coincap.io/assets/basic-attention-token'">
			<a href="https://coincap.io/assets/basic-attention-token">BAT</a></td>
			<td><%out.println(currency.getRSI()[2]);%></td>
			<td><%out.println(currency.getEMA()[2]);%></td>
			<td><%out.println(currency.getDeviation()[2]);%></td>
		</tr>
    <tr>
			<td onclick="location.href='https://coincap.io/assets/bitcoin-cash'">
			<a href="https://coincap.io/assets/bitcoin-cash">BCH</a></td>
			<td><%out.println(currency.getRSI()[3]);%></td>
			<td><%out.println(currency.getEMA()[3]);%></td>
			<td><%out.println(currency.getDeviation()[3]);%></td>
		</tr>
    <tr>
			<td onclick="location.href='https://coincap.io/assets/bitcoin'">
			<a href="https://coincap.io/assets/bitcoin">BTC</a></td>
			<td><%out.println(currency.getRSI()[4]);%></td>
			<td><%out.println(currency.getEMA()[4]);%></td>
			<td><%out.println(currency.getDeviation()[4]);%></td>
		</tr>
		
		<tr>
			<td onclick="location.href='https://coincap.io/assets/compound'">
			<a href="https://coincap.io/assets/compound">COMP</a></td>
			<td><%out.println(currency.getRSI()[28]);%></td>
			<td><%out.println(currency.getEMA()[28]);%></td>
			<td><%out.println(currency.getDeviation()[28]);%></td>
		</tr>
    <tr>
			<td onclick="location.href='https://coincap.io/assets/civic'">
			<a href="https://coincap.io/assets/civic">CVC</a></td>
			<td><%out.println(currency.getRSI()[5]);%></td>
			<td><%out.println(currency.getEMA()[5]);%></td>
			<td><%out.println(currency.getDeviation()[5]);%></td>
		</tr>
		
		<tr>
			<td onclick="location.href='https://coincap.io/assets/dai'">
			<a href="https://coincap.io/assets/dai">DAI</a></td>
			<td><%out.println(currency.getRSI()[6]);%></td>
			<td><%out.println(currency.getEMA()[6]);%></td>
			<td><%out.println(currency.getDeviation()[6]);%></td>
		</tr>
		
		<tr>
			<td onclick="location.href='https://coincap.io/assets/dash'">
			<a href="https://coincap.io/assets/dash">DASH</a></td>
			<td><%out.println(currency.getRSI()[7]);%></td>
			<td><%out.println(currency.getEMA()[7]);%></td>
			<td><%out.println(currency.getDeviation()[7]);%></td>
		</tr>
		
		<tr>
			<td onclick="location.href='https://coincap.io/assets/district0x'">
			<a href="https://coincap.io/assets/district0x">DNT</a></td>
			<td><%out.println(currency.getRSI()[8]);%></td>
			<td><%out.println(currency.getEMA()[8]);%></td>
			<td><%out.println(currency.getDeviation()[8]);%></td>
		</tr>
		
		<tr>
			<td onclick="location.href='https://coincap.io/assets/eos'">
			<a href="https://coincap.io/assets/eos">EOS</a></td>
			<td><%out.println(currency.getRSI()[9]);%></td>
			<td><%out.println(currency.getEMA()[9]);%></td>
			<td><%out.println(currency.getDeviation()[9]);%></td>
		</tr>
		
		<tr>
			<td onclick="location.href='https://coincap.io/assets/ethereum-classic'">
			<a href="https://coincap.io/assets/ethereum-classic">ETC</a></td>
			<td><%out.println(currency.getRSI()[10]);%></td>
			<td><%out.println(currency.getEMA()[10]);%></td>
			<td><%out.println(currency.getDeviation()[10]);%></td>
		</tr>
		
		<tr>
			<td onclick="location.href='https://coincap.io/assets/ethereum'">
			<a href="https://coincap.io/assets/ethereum">ETH</a></td>
			<td><%out.println(currency.getRSI()[11]);%></td>
			<td><%out.println(currency.getEMA()[11]);%></td>
			<td><%out.println(currency.getDeviation()[11]);%></td>
		</tr>
		
		<tr>
			<td onclick="location.href='https://coincap.io/assets/golem'">
			<a href="https://coincap.io/assets/golem">GNT</a></td>
			<td><%out.println(currency.getRSI()[12]);%></td>
			<td><%out.println(currency.getEMA()[12]);%></td>
			<td><%out.println(currency.getDeviation()[12]);%></td>
		</tr>
		
		<tr>
			<td onclick="location.href='https://coincap.io/assets/kyber-network'">
			<a href="https://coincap.io/assets/kyber-network">KNC</a></td>
			<td><%out.println(currency.getRSI()[13]);%></td>
			<td><%out.println(currency.getEMA()[13]);%></td>
			<td><%out.println(currency.getDeviation()[13]);%></td>
		</tr>
		
		<tr>
			<td onclick="location.href='https://coincap.io/assets/chainlink'">
			<a href="https://coincap.io/assets/chainlink">LINK</a></td>
			<td><%out.println(currency.getRSI()[14]);%></td>
			<td><%out.println(currency.getEMA()[14]);%></td>
			<td><%out.println(currency.getDeviation()[14]);%></td>
		</tr>
		
		<tr>
			<td onclick="location.href='https://coincap.io/assets/loom-network'">
			<a href="https://coincap.io/assets/loom-network">LOOM</a></td>
			<td><%out.println(currency.getRSI()[15]);%></td>
			<td><%out.println(currency.getEMA()[15]);%></td>
			<td><%out.println(currency.getDeviation()[15]);%></td>
		</tr>
		
		<tr>
			<td onclick="location.href='https://coincap.io/assets/litecoin'">
			<a href="https://coincap.io/assets/litecoin">LTC</a></td>
			<td><%out.println(currency.getRSI()[16]);%></td>
			<td><%out.println(currency.getEMA()[16]);%></td>
			<td><%out.println(currency.getDeviation()[16]);%></td>
		</tr>
		
		<tr>
			<td onclick="location.href='https://coincap.io/assets/decentraland'">
			<a href="https://coincap.io/assets/decentraland">MANA</a></td>
			<td><%out.println(currency.getRSI()[17]);%></td>
			<td><%out.println(currency.getEMA()[17]);%></td>
			<td><%out.println(currency.getDeviation()[17]);%></td>
		</tr>
		
		<tr>
			<td onclick="location.href='https://coincap.io/assets/maker'">
			<a href="https://coincap.io/assets/maker">MKR</a></td>
			<td><%out.println(currency.getRSI()[18]);%></td>
			<td><%out.println(currency.getEMA()[18]);%></td>
			<td><%out.println(currency.getDeviation()[18]);%></td>
		</tr>
		
		<tr>
			<td onclick="location.href='https://coincap.io/assets/omisego'">
			<a href="https://coincap.io/assets/omisego">OMG</a></td>
			<td><%out.println(currency.getRSI()[19]);%></td>
			<td><%out.println(currency.getEMA()[19]);%></td>
			<td><%out.println(currency.getDeviation()[19]);%></td>
		</tr>
		
		<tr>
			<td onclick="location.href='https://coincap.io/assets/orchid'">
			<a href="https://coincap.io/assets/orchid">OXT</a></td>
			<td><%out.println(currency.getRSI()[20]);%></td>
			<td><%out.println(currency.getEMA()[20]);%></td>
			<td><%out.println(currency.getDeviation()[20]);%></td>
		</tr>
		
		<tr>
			<td onclick="location.href='https://coincap.io/assets/augur'">
			<a href="https://coincap.io/assets/augur">REP</a></td>
			<td><%out.println(currency.getRSI()[21]);%></td>
			<td><%out.println(currency.getEMA()[21]);%></td>
			<td><%out.println(currency.getDeviation()[21]);%></td>
		</tr>
		
		<tr>
			<td onclick="location.href='https://coincap.io/assets/stellar'">
			<a href="https://coincap.io/assets/stellar">XLM</a></td>
			<td><%out.println(currency.getRSI()[23]);%></td>
			<td><%out.println(currency.getEMA()[23]);%></td>
			<td><%out.println(currency.getDeviation()[23]);%></td>
		</tr>
		
		<tr>
			<td onclick="location.href='https://coincap.io/assets/ripple'">
			<a href="https://coincap.io/assets/ripple">XRP</a></td>
			<td><%out.println(currency.getRSI()[24]);%></td>
			<td><%out.println(currency.getEMA()[24]);%></td>
			<td><%out.println(currency.getDeviation()[24]);%></td>
		</tr>
		
		<tr>
			<td onclick="location.href='https://coincap.io/assets/tezos'">
			<a href="https://coincap.io/assets/tezos">XTZ</a></td>
			<td><%out.println(currency.getRSI()[25]);%></td>
			<td><%out.println(currency.getEMA()[25]);%></td>
			<td><%out.println(currency.getDeviation()[25]);%></td>
		</tr>
		
		<tr>
			<td onclick="location.href='https://coincap.io/assets/zcash'">
			<a href="https://coincap.io/assets/zcash">ZEC</a></td>
			<td><%out.println(currency.getRSI()[26]);%></td>
			<td><%out.println(currency.getEMA()[26]);%></td>
			<td><%out.println(currency.getDeviation()[26]);%></td>
		</tr>
		
		<tr>
			<td onclick="location.href='https://coincap.io/assets/0x'">
			<a href="https://coincap.io/assets/0x">ZRX</a></td>
			<td><%out.println(currency.getRSI()[27]);%></td>
			<td><%out.println(currency.getEMA()[27]);%></td>
			<td><%out.println(currency.getDeviation()[27]);%></td>
		</tr>
		
	</tbody>
</table>
</html>