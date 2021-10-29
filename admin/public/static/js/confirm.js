Confirm = {
    show: function(message, callback) {
        Swal.fire({
            title: '确认?',
            text: message,
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: '是的, 删除!',
            cancelButtonText: '取消',
        }).then((result) => {
            Loading.show();
            if (result.isConfirmed) {
                if(callback) {
                    callback();
                }
            }
        })
    }
}