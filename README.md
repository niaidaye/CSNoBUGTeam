# CSNoBUGTeam

#### 介绍
王道学习团队，代码仓库

#### 文件架构
文件架构说明
- src——项目源代码
  - 每日任务，练习会发布在这里，小组成员可以这获取，但是不能修改里面的文件
- log——日志文件
  - 会存放一些每周总结的文件内容
- team——组员文件，各位组员只能更改自己的文件
  - eg：AiXu——这是AX的代码提交文件
  - eg：DengPen——这是DP的代码提交文件
  - 。。。。
- 
#### 仓库使用说明

1. 严格按照规定提交代码，避免给你的队友造成困惑
2. 建议先更新自己本地代码，在进行开发
3. 进行代码提交前，要自己先测试，没有BUG后在提交，
4. 提交代码时，一定要写清楚，本次提交，做啦哪些更改，或者完成哪些任务
   1. eg：
5. 开发前先看看别人提交的内容，以及commit——提交消息

#### git教程——常用命令

1.  Git安装后-指定名称和邮箱
```shell
$ git config --global user.name "Your Name"
 
$ git config --global user.email "email@example.com"

git config user.name           //查看用户名
git config user.password       //查看密码
git config user.email          //查看邮箱
git config --list              //查看配置信息
```
2. 创建本地仓库
```shell
$ mkdir learngit	//创建
$ cd learngit	    //使用
$ pwd	            //查看当前目录
$ git init	        //初始化,生成.git文件"若该文件隐藏，则使用ls -ah"
```
3. 添加和提交
```shell
$ git add test.txt	                 //添加
$ git commit -m "wrote a test file"	//提交
$ git commit -m "add 3 files."		//一次性提交多个文件

git status    //命令用于查看项目的当前状态.

git add --all //添加项目根目录下的所有改动内容
git add .     //只添加当前目录已经子目录下的改动内容
```
4. 版本控制
```shell
$ git log	                //查看提交历史记录，从最近到最远，可以看到3次
$ git log --pretty=oneline	//加参，简洁查看
$ git reflog	            //查看每一次修改历史
$ cat test.txt	            //查看文件内容
$ git status	            //查看工作区中文件当前状态


$ git reset HEAD^           // 回退所有内容到上一个版本  
$ git reset HEAD^ hello.php // 回退 hello.php 文件的版本到上一个版本  
$ git  reset  052e          // 回退到指定版本
```
5. 删除文件
```shell
$ rm test.txt
//直接删除
$ git rm test.txt
$ git commit -m "remove test.txt"
//删错了，恢复
$ git checkout -- test.txt
```
6. 远程仓库
```shell

$ ssh-keygen -t rsa -C "youremail@example.com"	//创建SSH Key

$ git remote add origin git@github.com:Daisy/AKgit.git	//关联
$ git push -u origin master	//将本地内容推送到远程仓库（第一次）
$ git push origin master	//将本地内容推送到远程仓库（之后）

$ git remote -v        //查看远程仓库信息
$ git remote rm origin	//删除远程仓库（解绑）

$ git clone git@github.com: Daisy/AKgit.git	//克隆远程仓库
//克隆之后使用和查看
$ cd gitskills
$ ls

$ git remote	//查看远程库的信息
$ git remote -v	//查看远程库的详细信息
```
7. 多人协作
```shell
$ git checkout -b dev	         //创建并切换到分支dev
   //创建并切换到分支dev，同上
$ git branch dev	             //创建
$ git checkout dev	             //切换
//新版本
$ git switch -c dev	             //创建并切换到分支dev
$ git switch master	             //直接切换分支


$ git branch		                //查看当前分支
$ git merge dev	（--no-ff）(-m)     //合并，把dev分支的工作成果合并到master分支上
$ git branch -d dev	                //删除dev分支 


$ git push origin master（dev）	    //推送分支
$ git checkout -b dev origin/dev	//创建远程origin的dev分支到本地
$ git pull	                        //抓取分支（解决冲突）
$ git branch --set-upstream-to=origin/dev dev      //指定本地与远程dev的链接
$ git rebase	                     //把本地未push的分叉提交历史整理成直线

origin就是远程仓库的一个别名，当然也可以写成项目完整地址，但是这样显然比较麻烦
```
8. 远程仓库本地仓库关联
```shell
1、首先创建本地分支，并切换到本地分支
git checkout -b 本地分支名 
2、提交本地分支到远程仓库
git push origin dev 将本地分支提交到了 远程dev分支  也就是创建了dev分支
3、本地分支与远程分支相关联
git branch –set-upstream 本地分支名 origin/远程分支名
fatal: the '--set-upstream' option is no longer supported. Please use '--track' or '--set-upstream-to' instead.

git branch --set-upstream-to=origin/dev dev 
```

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  Gitee 官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解 Gitee 上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是 Gitee 最有价值开源项目，是综合评定出的优秀开源项目
5.  Gitee 官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  Gitee 封面人物是一档用来展示 Gitee 会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
