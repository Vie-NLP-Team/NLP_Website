let api = [];
const apiDocListSize = 2
api.push({
    name: 'CRUD',
    order: '1',
    list: []
})
api[0].list.push({
    alias: 'ArticleController',
    order: '1',
    link: '(article)表控制层',
    desc: '(Article)表控制层',
    list: []
})
api[0].list[0].list.push({
    order: '1',
    deprecated: 'false',
    url: 'http://localhost:8080/article/{id}',
    desc: '通过主键查询单条数据',
});
api[0].list[0].list.push({
    order: '2',
    deprecated: 'false',
    url: 'http://localhost:8080/article/body/{body}',
    desc: '通过body属性查询单条数据',
});
api[0].list[0].list.push({
    order: '3',
    deprecated: 'false',
    url: 'http://localhost:8080/article/{page}/{size}',
    desc: '分页查询',
});
api[0].list[0].list.push({
    order: '4',
    deprecated: 'false',
    url: 'http://localhost:8080/article',
    desc: '新增数据',
});
api[0].list[0].list.push({
    order: '5',
    deprecated: 'false',
    url: 'http://localhost:8080/article',
    desc: '编辑数据',
});
api[0].list[0].list.push({
    order: '6',
    deprecated: 'false',
    url: 'http://localhost:8080/article',
    desc: '删除数据',
});
api[0].list[0].list.push({
    order: '7',
    deprecated: 'false',
    url: 'http://localhost:8080/article/webSum',
    desc: '返回根据新闻社分别统计的文章的总数',
});
api[0].list[0].list.push({
    order: '8',
    deprecated: 'false',
    url: 'http://localhost:8080/article/webSum/sen/{sentiment}',
    desc: '返回根据新闻社类别统计的文章下的正面态度和负面态度的总数',
});
api[0].list[0].list.push({
    order: '9',
    deprecated: 'false',
    url: 'http://localhost:8080/article/queryWebSenEventSum/{monthevent}/{sentiment}',
    desc: '统计每个事件的各个新闻社的新闻数量(分正面和负面)',
});
api[0].list.push({
    alias: 'EventController',
    order: '2',
    link: '(event)表控制层',
    desc: '(Event)表控制层',
    list: []
})
api[0].list[1].list.push({
    order: '1',
    deprecated: 'false',
    url: 'http://localhost:8080/event',
    desc: '返回全部事件内容',
});
api[0].list[1].list.push({
    order: '2',
    deprecated: 'false',
    url: 'http://localhost:8080/event/{newscycle}',
    desc: '通过热点事件周期返回事件列表',
});
api[0].list.push({
    alias: 'MonthController',
    order: '3',
    link: '(month)表控制层',
    desc: '(Month)表控制层',
    list: []
})
api[0].list[2].list.push({
    order: '1',
    deprecated: 'false',
    url: 'http://localhost:8080/montharticle/{monthevent}',
    desc: '通过热点事件id返回新闻列表',
});
api[0].list.push({
    alias: 'WordsController',
    order: '4',
    link: '(words)表控制层',
    desc: '(Words)表控制层',
    list: []
})
api[0].list[3].list.push({
    order: '1',
    deprecated: 'false',
    url: 'http://localhost:8080/words',
    desc: '高频词词云可视化',
});
api.push({
    name: 'Quartz',
    order: '2',
    list: []
})
api[1].list.push({
    alias: 'ClusterController',
    order: '1',
    link: '(event)表控制层',
    desc: '(Event)表控制层',
    list: []
})
api[1].list.push({
    alias: 'PretreatmentController',
    order: '2',
    link: '(article_website)表控制层',
    desc: '(Article_website)表控制层',
    list: []
})
api[1].list[1].list.push({
    order: '1',
    deprecated: 'false',
    url: 'http://localhost:8080/pre/count',
    desc: '新闻事件统计的预处理',
});
api[1].list.push({
    alias: 'SentimentController',
    order: '3',
    link: '(article)表控制层',
    desc: '(Article)表控制层',
    list: []
})
api[1].list[2].list.push({
    order: '1',
    deprecated: 'false',
    url: 'http://localhost:8080/analyse/all/{first}/{last}',
    desc: '新闻语料分词，词性标注，命名实体识别，以及依赖解析 (可选)',
});
api[1].list[2].list.push({
    order: '2',
    deprecated: 'false',
    url: 'http://localhost:8080/analyse/trans',
    desc: '分词翻译 (越南语转中文)',
});
document.onkeydown = keyDownSearch;
function keyDownSearch(e) {
    const theEvent = e;
    const code = theEvent.keyCode || theEvent.which || theEvent.charCode;
    if (code === 13) {
        const search = document.getElementById('search');
        const searchValue = search.value.toLocaleLowerCase();

        let searchGroup = [];
        for (let i = 0; i < api.length; i++) {

            let apiGroup = api[i];

            let searchArr = [];
            for (let i = 0; i < apiGroup.list.length; i++) {
                let apiData = apiGroup.list[i];
                const desc = apiData.desc;
                if (desc.toLocaleLowerCase().indexOf(searchValue) > -1) {
                    searchArr.push({
                        order: apiData.order,
                        desc: apiData.desc,
                        link: apiData.link,
                        list: apiData.list
                    });
                } else {
                    let methodList = apiData.list || [];
                    let methodListTemp = [];
                    for (let j = 0; j < methodList.length; j++) {
                        const methodData = methodList[j];
                        const methodDesc = methodData.desc;
                        if (methodDesc.toLocaleLowerCase().indexOf(searchValue) > -1) {
                            methodListTemp.push(methodData);
                            break;
                        }
                    }
                    if (methodListTemp.length > 0) {
                        const data = {
                            order: apiData.order,
                            desc: apiData.desc,
                            link: apiData.link,
                            list: methodListTemp
                        };
                        searchArr.push(data);
                    }
                }
            }
            if (apiGroup.name.toLocaleLowerCase().indexOf(searchValue) > -1) {
                searchGroup.push({
                    name: apiGroup.name,
                    order: apiGroup.order,
                    list: searchArr
                });
                continue;
            }
            if (searchArr.length === 0) {
                continue;
            }
            searchGroup.push({
                name: apiGroup.name,
                order: apiGroup.order,
                list: searchArr
            });
        }
        let html;
        if (searchValue === '') {
            const liClass = "";
            const display = "display: none";
            html = buildAccordion(api,liClass,display);
            document.getElementById('accordion').innerHTML = html;
        } else {
            const liClass = "open";
            const display = "display: block";
            html = buildAccordion(searchGroup,liClass,display);
            document.getElementById('accordion').innerHTML = html;
        }
        const Accordion = function (el, multiple) {
            this.el = el || {};
            this.multiple = multiple || false;
            const links = this.el.find('.dd');
            links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown);
        };
        Accordion.prototype.dropdown = function (e) {
            const $el = e.data.el;
            let $this = $(this), $next = $this.next();
            $next.slideToggle();
            $this.parent().toggleClass('open');
            if (!e.data.multiple) {
                $el.find('.submenu').not($next).slideUp("20").parent().removeClass('open');
            }
        };
        new Accordion($('#accordion'), false);
    }
}

function buildAccordion(apiGroups, liClass, display) {
    let html = "";
    if (apiGroups.length > 0) {
        if (apiDocListSize === 1) {
            let apiData = apiGroups[0].list;
            let order = apiGroups[0].order;
            for (let j = 0; j < apiData.length; j++) {
                html += '<li class="'+liClass+'">';
                html += '<a class="dd" href="#_'+order+'_'+apiData[j].order+'_' + apiData[j].link + '">' + apiData[j].order + '.&nbsp;' + apiData[j].desc + '</a>';
                html += '<ul class="sectlevel2" style="'+display+'">';
                let doc = apiData[j].list;
                for (let m = 0; m < doc.length; m++) {
                    let spanString;
                    if (doc[m].deprecated === 'true') {
                        spanString='<span class="line-through">';
                    } else {
                        spanString='<span>';
                    }
                    html += '<li><a href="#_'+order+'_' + apiData[j].order + '_' + doc[m].order + '_' + doc[m].desc + '">' + apiData[j].order + '.' + doc[m].order + '.&nbsp;' + spanString + doc[m].desc + '<span></a> </li>';
                }
                html += '</ul>';
                html += '</li>';
            }
        } else {
            for (let i = 0; i < apiGroups.length; i++) {
                let apiGroup = apiGroups[i];
                html += '<li class="'+liClass+'">';
                html += '<a class="dd" href="#_'+apiGroup.order+'_' + apiGroup.name + '">' + apiGroup.order + '.&nbsp;' + apiGroup.name + '</a>';
                html += '<ul class="sectlevel1">';

                let apiData = apiGroup.list;
                for (let j = 0; j < apiData.length; j++) {
                    html += '<li class="'+liClass+'">';
                    html += '<a class="dd" href="#_'+apiGroup.order+'_'+ apiData[j].order + '_'+ apiData[j].link + '">' +apiGroup.order+'.'+ apiData[j].order + '.&nbsp;' + apiData[j].desc + '</a>';
                    html += '<ul class="sectlevel2" style="'+display+'">';
                    let doc = apiData[j].list;
                    for (let m = 0; m < doc.length; m++) {
                       let spanString;
                       if (doc[m].deprecated === 'true') {
                           spanString='<span class="line-through">';
                       } else {
                           spanString='<span>';
                       }
                       html += '<li><a href="#_'+apiGroup.order+'_' + apiData[j].order + '_' + doc[m].order + '_' + doc[m].desc + '">'+apiGroup.order+'.' + apiData[j].order + '.' + doc[m].order + '.&nbsp;' + spanString + doc[m].desc + '<span></a> </li>';
                   }
                    html += '</ul>';
                    html += '</li>';
                }

                html += '</ul>';
                html += '</li>';
            }
        }
    }
    return html;
}