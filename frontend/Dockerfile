FROM node:18-alpine
WORKDIR /app
COPY . .
RUN npm install -g http-server
EXPOSE 3000
CMD ["http-server", "-p", "3000"]