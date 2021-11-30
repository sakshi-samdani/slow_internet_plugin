#
# To learn more about a Podspec see http://guides.cocoapods.org/syntax/podspec.html.
# Run `pod lib lint slow_internet_plugin.podspec` to validate before publishing.
#
Pod::Spec.new do |s|
  s.name             = 'slow_internet_plugin'
  s.version          = '0.0.1'
  s.summary          = 'A new Flutter project to check whether the internet connectivity is slow or fast.'
  s.description      = <<-DESC
A new Flutter project to check whether the internet connectivity is slow or fast.
                       DESC
  s.homepage         = 'http://example.com'
  s.license          = { :file => '../LICENSE' }
  s.author           = { 'Your Company' => 'email@example.com' }
  s.source           = { :path => '.' }
  s.source_files = 'Classes/**/*'
  s.dependency 'Flutter'
  s.platform = :ios, '8.0'

  # Flutter.framework does not contain a i386 slice.
  s.pod_target_xcconfig = { 'DEFINES_MODULE' => 'YES', 'EXCLUDED_ARCHS[sdk=iphonesimulator*]' => 'i386' }
  s.swift_version = '5.0'
end
