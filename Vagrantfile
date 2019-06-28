require 'vagrant-openstack-provider'

Vagrant.configure('2') do |config|

  config.ssh.username = 'ubuntu'
  config.ssh.private_key_path = ENV['OS_PRIVATE_KEY_PATH']

  config.vm.provider :openstack do |os, override|
    os.identity_api_version = ENV['OS_IDENTITY_API_VERSION']
    os.openstack_auth_url = ENV['OS_AUTH_URL']
    os.username           = ENV['OS_USERNAME']
    os.domain_name        = ENV['OS_DOMAIN_NAME']
    os.password           = ENV['OS_PASSWORD']
    os.tenant_name        = ENV['OS_TENANT_NAME']
    os.project_name       = ENV['OS_PROJECT_NAME']
    os.keypair_name       = ENV['OS_KEY_PAIR_NAME']
    os.region             = ENV['OS_REGION_NAME']
    os.image              = ENV['OS_IMAGE']
    override.vm.synced_folder '.', '/vagrant', disabled: true
  end

  config.vm.define 'server-1' do |s|
    s.vm.provision "shell", inline: "mkdir /home/ubuntu/jenkins_home; chown -R ubuntu:ubuntu /home/ubuntu/jenkins_home"
    s.vm.provision "shell", inline: "mkdir /home/ubuntu/docker; chown -R ubuntu:ubuntu /home/ubuntu/docker"
    s.vm.provision "docker"
    s.vm.provision "docker_compose", compose_version: '1.23.2'
    s.vm.provision "file", source: "docker-compose.yml", destination: "/home/ubuntu/docker/docker-compose.yml"
    s.vm.provision "shell", inline: "cd /home/ubuntu/docker; docker-compose up"
    s.vm.provider :openstack do |os, override|
      os.server_name = "AT09#{ENV['OS_INITIALS']}01"
      os.flavor = ENV['OS_FLAVOR']
    end
  end

  config.vm.define 'server-2' do |s|
    s.vm.provider :openstack do |os, override|
      os.server_name = "AT09#{ENV['OS_INITIALS']}02"
      os.flavor = ENV['OS_FLAVOR']
    end
  end
end