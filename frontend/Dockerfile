# Node.js ベースのイメージを使用
FROM node:14

# 作業ディレクトリを設定
WORKDIR /app

# パッケージのインストール
RUN npm install

# ポートのエクスポート
EXPOSE 3000

# サーバを起動
CMD ["npm", "start"]
