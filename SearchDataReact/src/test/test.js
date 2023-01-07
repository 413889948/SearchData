import React, {useEffect, useState} from 'react';
import './test.css';
import {Row, Col} from 'antd';
import {Button, Space} from 'antd';
import {Input} from 'antd';
import {Card, List} from 'antd';
import {Modal, Form, Divider, message, Popconfirm} from 'antd';
import {fetchPost, getUrl} from "../commen/DefaultConfig";
import InfiniteScroll from 'react-infinite-scroll-component';

const {TextArea} = Input;
const Test = () => {

    const [searchData, setSearchData] = useState('');
    const [addShow, setAddShow] = useState(false);
    const [data, setData] = useState([]);
    const [page, setPage] = useState({});
    const [editId, setEditId] = useState('');
    // 每页条数
    const size = 20;
    //当前页
    const [current, setCurrent] = useState(0);
    const search = (cur = 1) => {
        const base = {
            query: {
                dataName: searchData
            },
            page: {
                size,
                current: cur
            }
        };
        fetchPost(base, '/listKeywordData')
            .then((res) => res.json()).then(
            (result) => {
                // 只有下一页的时候进行补充数据操作
                if (cur !== 1) {
                    setData(data.concat(result.records));
                } else {
                    setData(result.records);
                }
                setPage(result);
                setCurrent(result.current);
            }
        );

    };
    const [form] = Form.useForm();
    useEffect(() => {
        search();
    }, []);
    const resetFields = () => {
        form.resetFields();
        setEditId('');
    };
    return (
        <div id="test" style={{backgroundColor: 'rgb(235,236,237)', height: '100vh'}}>
            <Modal title="新增字典" visible={addShow} onOk={async () => {
                if (!(await form.validateFields())) return;
                const result = await fetchPost({...form.getFieldsValue(), id: editId}, '/addUpdateKeywordData')
                if (result) {
                    message.success('保存成功');
                    search();
                }
                setAddShow(false);
            }} onCancel={() => setAddShow(false)}
                   cancelText={'取消'}
                   okText={'提交'}
            >
                <Form
                    labelCol={{span: 4}}
                    wrapperCol={{span: 18}}
                    layout="horizontal"
                    form={form}
                >
                    <Form.Item label="字典名称" name="dataName" rules={[{required: true, message: '字典名称不能为空！'}]}>
                        <Input maxLength={50}/>
                    </Form.Item>
                    <Form.Item label="字典解释" name="dataExplain" rules={[{required: true, message: '字典解释不能为空！'}]}>
                        <TextArea rows={4} maxLength={2000}/>
                    </Form.Item>
                    <Form.Item label="备注" name="dataRemark">
                        <TextArea rows={4} maxLength={2000}/>
                    </Form.Item>
                </Form>
            </Modal>

            <Row>

                <Col span={2}>
                </Col>
                <Col span={20} style={{padding: '18px', backgroundColor: 'aliceblue'}}>

                    <Space>
                        <Input placeholder="字典名称" onChange={e => {
                            setSearchData(e.target.value);
                        }}/>
                        <Button type="primary" onClick={() => {
                            search();
                        }}>查询</Button>
                        <Button onClick={() => {
                            resetFields();
                            setAddShow(true);
                        }}>新增</Button>
                    </Space>

                    <div style={{margin: '10px 0px'}}>
                        <InfiniteScroll
                            dataLength={data.length}
                            next={() => search(current + 1)}
                            hasMore={data.length < page.total}
                            loader={<div
                                style={{
                                    textAlign: 'center',
                                    marginTop: 12,
                                    height: 32,
                                    lineHeight: '32px',
                                }}
                            ><Button onClick={search}>加载更多</Button></div>}
                            endMessage={<Divider plain>出。。出不来拉。。。</Divider>}
                            scrollableTarget="scrollableDiv"
                        >
                            <div
                                style={{
                                    overflowX: 'hidden'
                                }}
                            >
                                <List
                                    grid={{
                                        gutter: 16,
                                        xs: 1,
                                        sm: 2,
                                        md: 4,
                                        lg: 4,
                                        xl: 6,
                                        xxl: 3,
                                    }}
                                    dataSource={data}
                                    renderItem={(item) => (
                                        <List.Item>
                                            <Card title={item.dataName} extra={<div>
                                                <a style={{marginRight: '10px'}} onClick={() => {
                                                    form.setFields([
                                                        {name: 'dataName', value: item.dataName},
                                                        {name: 'dataExplain', value: item.dataExplain},
                                                        {name: 'dataRemark', value: item.dataRemark},
                                                    ]);
                                                    setEditId(item.id)
                                                    setAddShow(true);
                                                }}>编辑</a>
                                                <Popconfirm
                                                    placement="topRight"
                                                    title={'是否确认删除？'}
                                                    onConfirm={() => {
                                                        fetchPost({id: item.id, del: '1'}, '/addUpdateKeywordData')
                                                            .then((res) => res.json()).then(
                                                            (result) => {
                                                                if (result) {
                                                                    message.success('删除成功');
                                                                    search();
                                                                }
                                                            }
                                                        );
                                                    }}
                                                    okText="是"
                                                    cancelText="否"
                                                >
                                                    <a>
                                                        删除
                                                    </a>
                                                </Popconfirm>


                                            </div>}>
                                                <div>{item.dataExplain}</div>
                                                <div style={{
                                                    fontSize: 'small',
                                                    fontStyle: 'italic',
                                                    color: 'brown'
                                                }}>
                                                    备注：{item.dataRemark}
                                                </div>

                                            </Card>
                                        </List.Item>
                                    )}
                                >

                                </List>
                            </div>

                        </InfiniteScroll>
                    </div>

                </Col>
                <Col span={2}>

                </Col>
            </Row>
        </div>
    );
};
export {Test};