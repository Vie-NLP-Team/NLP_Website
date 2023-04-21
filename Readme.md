[Update]2.0.1
    1.查询event表部分属性
        处理表: event
        输入数据: 无
        输出数据:
            event表下的
                event_id, title, keyword, abstract
        api: http://localhost:8080/event


    2.根据周期返回热点事件(本周本月本季)
        处理表: event
        输入数据: news_cycle(周期)
        输出数据:
            event表下的
                event_id, title, keyword, abstract, sentiment_pos, sentiment_neg, sentiment_middle, count_event, news_cycle
        api: http://localhost:8080/event/{news_cycle}


    3.通过热点事件id返回新闻列表(再加上摘要文章内容和图片url)
        处理表: articleDto, montharticle
        输入数据: monthevent
        输出数据:
            article表下的
                id, title, pub_time, abstract1, body, images
        api: http://localhost:8080/montharticle/{monthevent}


<--------------------------------------------------------------------------------------------------->


[Update]2.0.2
    1.返回根据新闻社类别统计的文章的总数
        处理表: website, articleDto
        输入数据: 无
        输出数据:
            website表下的
                web_name
            由article表建立的临时表中的
                article_count(文章总数)
        api: http://localhost:8080/articleDto/queryWebArticleSum


    2.返回根据新闻社类别统计的文章的正面或负面总数
            处理表: website, articleDto, montharticle
            输入数据: sentiment(1代表统计正面文章数，0代表统计负面文章数)
            输出数据:
                website表下的
                    web_name
                由article表和montharticle建立的临时表中的
                    sentiment_count(正面或负面文章总数)
            api: http://localhost:8080/articleDto/queryWebSenSum/{sentiment}


<--------------------------------------------------------------------------------------------------->


[Update]2.0.3
    2.统计每个事件的各个新闻社的新闻数量(分正面和负面)
            处理表: website, articleDto, montharticle
            输入数据:
                sentiment(1代表统计正面文章数，0代表统计负面文章数)
                monthevent(事件编号)
            输出数据:
                website表下的
                    web_name
                由article表和montharticle建立的临时表中的
                    article_count(正面或负面文章总数)
            api: http://localhost:8080/articleDto/queryWebSenEventSum/{monthevent}/{sentiment}
