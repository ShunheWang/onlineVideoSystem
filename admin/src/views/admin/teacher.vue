<template>
    <div>
        <p>
            <button v-on:click="add()" class="btn btn-white btn-default btn-round">
                <i class="ace-icon fa fa-edit"></i>
                新增
            </button>
            &nbsp;
            <button v-on:click="list(1)" class="btn btn-white btn-default btn-round">
                <i class="ace-icon fa fa-refresh red2"></i>
                刷新
            </button>
        </p>

        <pagination ref="pagination" v-bind:list="list" v-bind:itemCount="8"></pagination>

        <!-- <table id="simple-table" class="table  table-bordered table-hover">
            <thead>
                    <tr>
                                                        <th>id</th>
                                <th>名称</th>
                                <th>昵称</th>
                                <th>头像</th>
                                <th>职位</th>
                                <th>座右铭</th>
                                <th>简介</th>
                        <th>操作</th>
                    </tr>
            </thead>

            <tbody>
                <tr v-for="teacher in teachers" :key="teacher.id">
                                <td>{{teacher.id}}</td>
                                <td>{{teacher.name}}</td>
                                <td>{{teacher.nickname}}</td>
                                <td>{{teacher.image}}</td>
                                <td>{{teacher.position}}</td>
                                <td>{{teacher.motto}}</td>
                                <td>{{teacher.intro}}</td>
                    <td>
                        <div class="hidden-sm hidden-xs btn-group">
                            <button v-on:click="edit(teacher)" class="btn btn-xs btn-info">
                                <i class="ace-icon fa fa-pencil bigger-120"></i>
                            </button>
                            <button v-on:click="del(teacher.id)" class="btn btn-xs btn-danger">
                                <i class="ace-icon fa fa-trash-o bigger-120"></i>
                            </button>
                        </div>

                        <div class="hidden-md hidden-lg">
                            <div class="inline pos-rel">
                                <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                    <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                                </button>

                                <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                    <li>
                                        <a href="#" class="tooltip-info" data-rel="tooltip" title="View">
                                            <span class="blue">
                                                <i class="ace-icon fa fa-search-plus bigger-120"></i>
                                            </span>
                                        </a>
                                    </li>

                                    <li>
                                        <a href="#" class="tooltip-success" data-rel="tooltip" title="Edit">
                                            <span class="green">
                                                <i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
                                            </span>
                                        </a>
                                    </li>

                                    <li>
                                        <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
                                            <span class="red">
                                                <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                            </span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </td>
                </tr>
            </tbody>
        </table> -->

        <div class="col-xs-12 col-sm-3 center">
            <div>
                <span class="profile-picture">
                    <img id="avatar" class="editable img-responsive editable-click editable-empty" alt="Alex's Avatar" src="assets/images/avatars/profile-pic.jpg" style="display: block;">
                </span>

                <div class="space-4"></div>

                <div class="width-85 label label-info label-xlg arrowed-in arrowed-in-right">
                    <div class="inline position-relative">
                        <a href="#" class="user-title-label dropdown-toggle" data-toggle="dropdown">
                            <i class="ace-icon fa fa-circle light-green"></i>
                            &nbsp;
                            <span class="white">Alex M. Doe</span>
                        </a>

                        <ul class="align-left dropdown-menu dropdown-caret dropdown-lighter">
                            <li class="dropdown-header"> Change Status </li>

                            <li>
                                <a href="#">
                                    <i class="ace-icon fa fa-circle green"></i>
                                        &nbsp;
                                    <span class="green">Available</span>
                                </a>
                            </li>

                            <li>
                                <a href="#">
                                    <i class="ace-icon fa fa-circle red"></i>
                                        &nbsp;
                                    <span class="red">Busy</span>
                                </a>
                            </li>

                            <li>
                                <a href="#">
                                    <i class="ace-icon fa fa-circle grey"></i>
                                        &nbsp;
                                    <span class="grey">Invisible</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="space-6"></div>

            <div class="profile-contact-info">
                <div class="profile-contact-links align-left">
                    <a href="#" class="btn btn-link">
                        <i class="ace-icon fa fa-plus-circle bigger-120 green"></i>
                        Add as a friend
                    </a>

                    <a href="#" class="btn btn-link">
                        <i class="ace-icon fa fa-envelope bigger-120 pink"></i>
                        Send a message
                    </a>

                    <a href="#" class="btn btn-link">
                        <i class="ace-icon fa fa-globe bigger-125 blue"></i>
                        www.alexdoe.com
                    </a>
                </div>

                <div class="space-6"></div>

                <div class="profile-social-links align-center">
                    <a href="#" class="tooltip-info" title="" data-original-title="Visit my Facebook">
                        <i class="middle ace-icon fa fa-facebook-square fa-2x blue"></i>
                    </a>

                    <a href="#" class="tooltip-info" title="" data-original-title="Visit my Twitter">
                        <i class="middle ace-icon fa fa-twitter-square fa-2x light-blue"></i>
                    </a>

                    <a href="#" class="tooltip-error" title="" data-original-title="Visit my Pinterest">
                        <i class="middle ace-icon fa fa-pinterest-square fa-2x red"></i>
                    </a>
                </div>
            </div>

            <div class="hr hr12 dotted"></div>

            <div class="clearfix">
                <div class="grid2">
                    <span class="bigger-175 blue">25</span>

                    <br>
                    Followers
                </div>

                <div class="grid2">
                    <span class="bigger-175 blue">12</span>

                    <br>
                    Following
                </div>
            </div>

            <div class="hr hr16 dotted"></div>
        </div>


        <div id="form-modal" class="modal fade" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">表单</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">名称</label>
                                <div class="col-sm-10">
                                    <input v-model="teacher.name" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">昵称</label>
                                <div class="col-sm-10">
                                    <input v-model="teacher.nickname" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">头像</label>
                                <div class="col-sm-10">
                                    <input v-model="teacher.image" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">职位</label>
                                <div class="col-sm-10">
                                    <input v-model="teacher.position" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">座右铭</label>
                                <div class="col-sm-10">
                                    <input v-model="teacher.motto" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">简介</label>
                                <div class="col-sm-10">
                                    <textarea v-model="teacher.intro" class="form-control" rows="5"></textarea>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button v-on:click="save()" type="button" class="btn btn-primary">保存</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </div>
</template>

<script>
  import Pagination from "../../components/pagination";
  export default {
    components: {Pagination},
    name: 'business-teacher',
    data: function() {
        return {
            teacher: {},
            teachers: [],
        }
    },
    mounted: function() {
        let _this = this;
        // _this.list();
        _this.$refs.pagination.size = 5;
        _this.list(1);
    //   this.$parent.activeSidebar("business-teacher-sidebar");
    },
    methods: {

        /**
         * 添加
         */
        add() {
            let _this = this;
            _this.teachers = {};
            $("#form-modal").modal("show");
        },

        /**
         * 修改
         */
        edit(teacher) {
            let _this = this;
            _this.teacher = $.extend({}, teacher);
            $("#form-modal").modal("show");
        },

        /**
         * 保存
         */
        save() {
            let _this = this;

            // 保存校验
            if (1 != 1
                      || !Validator.require(_this.teacher.name, "名称")
                      || !Validator.length(_this.teacher.name, "名称", 1, 50)
                      || !Validator.length(_this.teacher.nickname, "昵称", 1, 50)
                      || !Validator.length(_this.teacher.image, "头像", 1, 100)
                      || !Validator.length(_this.teacher.position, "职位", 1, 50)
                      || !Validator.length(_this.teacher.motto, "座右铭", 1, 50)
                      || !Validator.length(_this.teacher.intro, "简介", 1, 500)
            ) {
              return;
            }

            Loading.show();
            _this.$ajax.post(process.env.VUE_APP_SERVER + '/business/admin/teacher/save', _this.teacher).then((response)=>{
                Loading.hide();
                let resp = response.data;
                if (resp.success) {
                    $("#form-modal").modal("hide");
                    _this.list(1);
                    toast.success("保存成功!");
                } else {
                    toast.warning(resp.message);
                }
            })
        },

        /**
         * 删除
         */
        del(id) {
            let _this = this;
            Confirm.show("删除讲师后不能恢复, 确认删除?", function() {
                Loading.show();
                _this.$ajax.delete(process.env.VUE_APP_SERVER + '/business/admin/teacher/delete/' + id).then((response)=>{
                Loading.hide();
                let resp = response.data;
                    if (resp.success) {
                        _this.list(1);
                        toast.success("删除成功!");
                    }
                })
            });
        },

        /**
         * 列表查询
         */
        list(page) {
            let _this = this;
            Loading.show();
            _this.$ajax.post(process.env.VUE_APP_SERVER + '/business/admin/teacher/list',{
                // page: 1,
                // size: 1
                page: page,
                size: _this.$refs.pagination.size,
            }).then((response) => {
                Loading.hide();
                let resp = response.data;
                _this.teachers = resp.content.list;
                _this.$refs.pagination.render(page, resp.content.total);
            })
        }
    }
  }
</script>