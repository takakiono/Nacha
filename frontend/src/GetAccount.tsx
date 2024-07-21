import React, { useState, useEffect } from "react";
import "./common.css";

interface Account {
    accountId: string;
    groupId: string;
    categoryId: string;
    note: string;
    amount: string;
    datetime: string;
}
  
interface ApiResponse {
  accounts: Account[];
}

export const GetAccount = () =>{
    const [accounts, setAccounts] = useState<Account[]>([]);
  
    useEffect(() => {
      async function fetchData() {
        try {
          const response = await fetch("http://localhost:8801/nacha/account?groupId=1&acquisitionMonth=2023-11", { method: "GET" });
          const data: ApiResponse = await response.json();
          setAccounts(data.accounts);
        } catch (error) {
          console.error('データの取得に失敗しました', error);
        }
      }
  
      fetchData();
    }, []);
  
    return (
      <div>
        <h1>Account Table</h1>
        <table>
          <thead>
            <tr>
              <th>家計簿ID</th>
              <th>グループID</th>
              <th>カテゴリID</th>
              <th>備考</th>
              <th>金額</th>
              <th>日付</th>
            </tr>
          </thead>
          <tbody>
            {accounts.map(account => (
              <tr key={account.accountId}>
                <td>{account.accountId}</td>
                <td>{account.groupId}</td>
                <td>{account.categoryId}</td>
                <td>{account.note}</td>
                <td>{account.amount}円</td>
                <td>{account.datetime}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
}