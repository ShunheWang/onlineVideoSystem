<template>
    <div>
        <h1>hey, maison</h1>
    </div>
</template>

<script>
  export default {
    name: 'wellcome',
    mounted: function() {
      this.$parent.activeSidebar("welcome-sidebar");
    },
    methods: {
    }
  }
</script>