git config user.name 查看用户名
git config user.email 查看邮箱
git config --global user.name "" 切换用户
git config --global user.email "" 切换邮箱


查看
git status

初始
  git init

  git add .

## 连接git库
   git remote add origin https://github.com/arranapl/apl-mogodb-java.git
    
    
提交描述

  git commit -m " " .


从git库拉取代码
  git pull -f origin master

合并代码
   自动合并
   解决冲突  vcs/git


推送代码到git库
  git push -u origin master
  git push -f origin master



解决.gitignore文件不生效
git rm -r --cached .
git add .
git commit -m 'update .gitignore'



