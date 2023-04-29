## 配置工作
首先需要将同文件夹下的 VnCoreNLP-1.2.jar 文件导入 lib 中，即 Add as library.

同时导入项目下的vie.sql文件.

然后需要检查运行主机上的组件是否与系统下导入的组件有冲突，出现 Warning 则删掉其中一个即可. (建议优先删掉本系统中的组件)

修改 application.yml 中与数据库进行对接的 url 以及用户名和密码

## 启动流程
启动 Springboot 项目后，在右边 Maven 仓库中找到 smart-doc 组件， 点开并运行 smart-doc:html 文件，生成一个测试文档. (位置在 resource/static/doc 下)

在测试接口文档网页完成后续工作.